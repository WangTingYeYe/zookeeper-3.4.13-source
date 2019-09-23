package com.luban.distributed_config;

import java.util.concurrent.TimeUnit;

/**
* @Description:
* @Param:
* @return:
* @Author: Micheal.Wang
* @Date: 2019/9/23 0023
*/
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Config config = new Config("localhost:2181");

        config.save("timeout", "1");
        for (int i=0; i<100; i++) {
            System.out.println("====="+config.get("timeout"));
            System.out.println("====="+config.get("grade"));
            TimeUnit.SECONDS.sleep(5);
        }
    }
}
