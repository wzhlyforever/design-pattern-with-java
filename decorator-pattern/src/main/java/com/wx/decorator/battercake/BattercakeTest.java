package com.wx.decorator.battercake;

/**
 * @program: design-pattern-with-java
 * @description:
 * @author: Mr.Wang
 * @create: 2021-05-18 16:14
 **/
public class BattercakeTest {
    public static void main(String[] args) {

        Battercake battercake;

        battercake = new BaseBattercake();

        battercake = new EggDecorator(battercake);

        battercake = new EggDecorator(battercake);

        battercake = new SausageDecorator(battercake);

        System.out.println(battercake.getMst() + "，总价：" + battercake.getPrice());
    }
}
