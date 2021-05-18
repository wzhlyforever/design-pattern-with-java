package com.wx.proxy.dbroute;

/**
 * @program: design-pattern-with-java
 * @description:
 * @author: Mr.Wang
 * @create: 2021-05-17 16:09
 **/
public class OrderDao {
    public int insert(Order order){
        System.out.println("OrderDao创建order成功");
        return 1;
    }
}
