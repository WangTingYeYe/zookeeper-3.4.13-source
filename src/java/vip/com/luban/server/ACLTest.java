package com.luban.server;

import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;

/***
* @Description:
* @Param:
* @return:
* @Author: Micheal.Wang
* @Date: 2019/9/23 0023
*/
public class ACLTest {

    public static void main(String[] args) {

        ACL acl1 = new ACL(1, new Id("auth", "zhangsan:12345"));
        ACL acl2 = new ACL(2, new Id("auth", "zhangsan:12345"));

        System.out.println(acl1.equals(acl2));
    }
}
