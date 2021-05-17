package com.wx.singleton.hungry;

/**
 * @program: design-pattern-with-java
 * @description: 饿汉式静态块单例模式 优点： 线程安全，执行效率高；缺点对系统的资源占用，系统初始化时，会造成大量的资源浪费
 * @author: Mr.Wang
 * @create: 2021-04-18 15:48
 **/
public class HungryStaticSinleton {
    private static final HungryStaticSinleton hungrySinleton;
    static {
        hungrySinleton = new HungryStaticSinleton();
    }
    private HungryStaticSinleton(){};

    public static HungryStaticSinleton getInstance(){
        return hungrySinleton;
    }

}
