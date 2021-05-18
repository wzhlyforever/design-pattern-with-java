package com.wx.decorator.battercake;

/**
 * @program: design-pattern-with-java
 * @description:
 * @author: Mr.Wang
 * @create: 2021-05-18 16:13
 **/
public class SausageDecorator extends BattercakeDecorator{

    public SausageDecorator(Battercake battercake) {
        super(battercake);
    }

    protected void doSomething() {

    }

    @Override
    public String getMst() {
        return super.getMst() + "1根香肠";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 2;
    }
}
