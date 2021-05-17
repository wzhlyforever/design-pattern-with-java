package com.wx.singleton.innerclass;

/**
 * @program: design-pattern-with-java
 * @description: 看似完美的静态内部类单例写法  既避免了饿汉式单例模式的内存浪费问题，解决了使用synchronized的性能问题
 * @author: Mr.Wang
 * @create: 2021-04-18 17:02
 **/
public class LazyStaticInnerClassSingleton {

    //   当使用LazyStaticInnerClassSingleton时, 会先初始化内部类
    //    当不使用时，则不会加载内部类

    private LazyStaticInnerClassSingleton(){
        if (LazyHolder.INSTANCE != null){
            throw new RuntimeException("不允许创建多个实例");
        }
    };

    private static LazyStaticInnerClassSingleton getInstance(){
        // 在返回结果之前一定先加载内部类
        return LazyHolder.INSTANCE;
    }

    //默认情况下，不会加载
    private static class LazyHolder{
        private static final LazyStaticInnerClassSingleton INSTANCE=new LazyStaticInnerClassSingleton();
    }
}
