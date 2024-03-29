package com.luban.client.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.common.Time;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
* @Description:
* @Param:
* @return:
* @Author: Micheal.Wang
* @Date: 2019/9/23 0023
*/
public class ZookeeperClientConnectionTest {

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        // 默认的watch
        ZooKeeper client = new ZooKeeper("localhost:2181", 5000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("默认的watch:" + event.getType());
            }
        });


        client.create("/luban-e", "1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);

        doTask(client);

        System.in.read();
    }

    private static void doTask(ZooKeeper client) {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(client.getChildren("/",false));
            } catch (InterruptedException e) {
//                e.printStackTrace();
            } catch (KeeperException e) {
//                e.printStackTrace();
            }


        }
    }
}
