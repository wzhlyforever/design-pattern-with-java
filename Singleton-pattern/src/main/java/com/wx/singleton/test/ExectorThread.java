package com.wx.singleton.test;

import com.wx.singleton.lazy.LazySimpleSingleton;

/**
 * @program: design-pattern-with-java
 * @description:
 * @author: Mr.Wang
 * @create: 2021-04-26 18:25
 **/
public class ExectorThread implements Runnable{

    public void run() {

        LazySimpleSingleton instance = LazySimpleSingleton.getInstance();
//        LazyDoubleCheckSingleton instance = LazyDoubleCheckSingleton.getInstance();
//        ThreadLocalSingleton instance = ThreadLocalSingleton.getInstance();
//        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(Thread.currentThread().getName() + ":" + instance);

    }


}
