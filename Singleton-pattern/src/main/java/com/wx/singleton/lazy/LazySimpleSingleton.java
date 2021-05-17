package com.wx.singleton.lazy;

/**
 * @program: design-pattern-with-java
 * @description: 懒汉式单例模式  优点 线程安全，不会发生资源占用 缺点，当有大量线程时，会产生资源阻塞
 * @author: Mr.Wang
 * @create: 2021-04-18 15:53
 **/
public class LazySimpleSingleton {
    private static LazySimpleSingleton instance = null;

    private LazySimpleSingleton(){};

    public static synchronized LazySimpleSingleton getInstance(){
        if (instance == null){
            instance = new LazySimpleSingleton();
        }

        return instance;
    }
}
