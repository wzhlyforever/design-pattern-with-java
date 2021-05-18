package com.wx.proxy.dynamicProxy.cgproxy;

/**
 * @program: design-pattern-with-java
 * @description:
 * @author: Mr.Wang
 * @create: 2021-05-17 18:58
 **/
public class CglibTest {

    public static void main(String[] args) {

        //jdk采取的是读取接口的信息
        //cglib采取的是覆盖父类的方法
        // 目的都是要生成一个新的类
        // jdk proxy 对于用户而言 必须要有一个接口实现，目标类实现相对复杂
        // cglib 可以任意代理一个普通的类，没有任何要求
        // 但是cglib 生成代理的逻辑更加复杂，调用效率更高，生成了一个包含所有逻辑的fastclass 不再需要反射调用
        Customer customer = (Customer) new CGLibMeipo().getInstance(Customer.class);
        customer.findLove();
    }
}
