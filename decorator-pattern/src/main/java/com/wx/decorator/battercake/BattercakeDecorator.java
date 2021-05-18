package com.wx.decorator.battercake;

/**
 * @program: design-pattern-with-java
 * @description:
 * @author: Mr.Wang
 * @create: 2021-05-18 16:08
 **/
public class BattercakeDecorator extends Battercake{

    private Battercake battercake;

    public BattercakeDecorator(Battercake battercake) {
        this.battercake = battercake;
    }


    public String getMst() {
        return this.battercake.getMst();
    }

    public int getPrice() {
        return this.battercake.getPrice();
    }
}
