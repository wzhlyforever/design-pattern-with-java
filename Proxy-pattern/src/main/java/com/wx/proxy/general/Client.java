package com.wx.proxy.general;

import org.springframework.util.SystemPropertyUtils;

/**
 * @program: design-pattern-with-java
 * @description: 代理模式的通用写法
 * 代理模式： 当客户端不能直接引用某个对象的时候，通过一个代理对象 ，用于代理真实对像，达到对这个真实对象的间接访问，
 * 用于代码增强，
 * @author: Mr.Wang
 * @create: 2021-05-17 11:35
 **/
public class Client {

    public static void main(String[] args) {
        final Proxy proxy = new Proxy(new RealSubject());
        proxy.request();
    }

    interface Isubject{
        void request();
    }

    //代理角色
    static class Proxy implements Isubject{
        private Isubject isubject;

        public Proxy(Isubject isubject){
            this.isubject = isubject;
        }

        public void request() {
            before();
            isubject.request();
            after();
        }

        public void before(){
            System.out.println("called before request()");
        }

        public void after(){
            System.out.println("called after request()");
        }
    }

    //真实主题
    static class  RealSubject implements Isubject{

        public void request() {
            System.out.println("real service is called!");
        }
    }
}
