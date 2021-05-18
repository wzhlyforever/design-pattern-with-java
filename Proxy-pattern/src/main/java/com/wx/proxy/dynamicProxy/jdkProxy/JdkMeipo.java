package com.wx.proxy.dynamicProxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: design-pattern-with-java
 * @description: 动态代理类
 * @author: Mr.Wang
 * @create: 2021-05-17 13:14
 **/
public class JdkMeipo implements InvocationHandler {

    /*
    动态代理 利用代理模式 生成动态代理类，代理真实对象， 当生成代理对象的同时需要提供一个invocationhandler 对象
    当代理对象调用调用真实对象的方法的时候， 会自动调用invocationhandler 的invoke方法
    因为代理对象需要在内部实现真实对象的接口方法时，底层会利用反射调用invokehandler 的invoke方法， 方法内部会去调用真实对象的方法
    * */

    private Iperson target;

    public Iperson getInstance(Iperson target){
        this.target = target;
        Class<? extends Iperson> aClass = target.getClass();
        return (Iperson) Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(this.target, args);
        after();
        return result;
    }

    private void before(){
        System.out.println("我是媒婆，我已经收集到你的需求，开始物色");
    }

    private void after(){
        System.out.println("双方同意，开始交往");
    }

}
