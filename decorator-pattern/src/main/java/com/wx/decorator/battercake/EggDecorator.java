package com.wx.decorator.battercake;

/**
 * @program: design-pattern-with-java
 * @description:
 * @author: Mr.Wang
 * @create: 2021-05-18 16:11
 **/
public class EggDecorator extends BattercakeDecorator{

    public EggDecorator(Battercake battercake) {
        super(battercake);
    }

    protected void doSomething() {

    }

    @Override
    public String getMst() {
        return super.getMst() + "1个鸡蛋";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 1;
    }
}
