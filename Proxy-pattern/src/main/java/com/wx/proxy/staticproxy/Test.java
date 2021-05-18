package com.wx.proxy.staticproxy;

/**
 * @program: design-pattern-with-java
 * @description:
 * @author: Mr.Wang
 * @create: 2021-05-17 12:47
 **/
public class Test {
    public static void main(String[] args) {
        final ZhangLaoSan zhangLaoSan = new ZhangLaoSan(new Zhangsan());
        zhangLaoSan.findLove();
    }
}

