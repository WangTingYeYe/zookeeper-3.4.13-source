package com.luban.client.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;

import java.util.concurrent.TimeUnit;

/**
* @Description:
* @Param:
* @return:
* @Author: Micheal.Wang
* @Date: 2019/9/23 0023
*/
public class CuratorSessionExample {

    static CuratorFramework client = CuratorFrameworkFactory.newClient("localhost:2181",10000,10000, new RetryNTimes(3, 3000));

    public static void doTask() {
        try {
//            client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath("/sessionTest", "1".getBytes());
            while (true) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(client.getChildren().forPath("/"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

        client.start();

        client.create().withMode(CreateMode.EPHEMERAL).forPath("/luban-e", "1".getBytes());

        client.getConnectionStateListenable().addListener(new ConnectionStateListener() {
            @Override
            public void stateChanged(CuratorFramework client, ConnectionState newState) {
                if(newState == ConnectionState.LOST){
                    while(true){
                        try {
                            if(client.getZookeeperClient().blockUntilConnectedOrTimedOut()){
                                doTask();
                                break;
                            }
                        } catch (InterruptedException e) {
                            break;
                        } catch (Exception e){

                        }
                    }
                }
            }
        });

        doTask();


    }
}
