package com.wx.singleton.test;

/**
 * @program: design-pattern-with-java
 * @description: 线程类测试
 * @author: Mr.Wang
 * @create: 2021-04-26 17:43
 **/
public class LazySimpleSingletonTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(new ExectorThread());
        Thread t2 = new Thread(new ExectorThread());
        t1.start();
        t2.start();
        System.out.println("End");
    }
}
