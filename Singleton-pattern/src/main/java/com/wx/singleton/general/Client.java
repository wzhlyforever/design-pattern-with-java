package com.wx.singleton.general;

/**
 * @program: design-pattern-with-java
 * @description: 单例模式的模式的通用写法 俗称：饿汉式单例模式
 * @author: Mr.Wang
 * @create: 2021-04-26 17:22
 **/
public class Client {

    public static void main(String[] args) {

    }

    static class Singleton {
        private static Singleton singleton = new Singleton();


        public static Singleton getInstance(){
            return singleton;
        }

    }
}
