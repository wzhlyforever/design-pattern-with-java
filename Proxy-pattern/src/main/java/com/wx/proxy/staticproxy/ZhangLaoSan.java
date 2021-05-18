package com.wx.proxy.staticproxy;

/**
 * @program: design-pattern-with-java
 * @description:
 * @author: Mr.Wang
 * @create: 2021-05-17 12:40
 **/
public class ZhangLaoSan implements Iperson{
    private Zhangsan zhangsan;


    public ZhangLaoSan(Zhangsan zhangsan){
        this.zhangsan = zhangsan;
    }

    public void findLove() {
        System.out.println("张老三开始物色");
        zhangsan.findLove();
        System.out.println("开始交往");
    }
}
