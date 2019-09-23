package com.luban.client.zkclient;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;

import java.io.IOException;

/**
* @Description:
* @Param:
* @return:
* @Author: Micheal.Wang
* @Date: 2019/9/23 0023
*/
public class ZkoClientWatchTest {

    public static void main(String[] args) throws IOException {
        ZkClient zk = new ZkClient("localhost:2181",10000, 10000, new SerializableSerializer());

        zk.writeData("/zkclient", "123");
    }
}
