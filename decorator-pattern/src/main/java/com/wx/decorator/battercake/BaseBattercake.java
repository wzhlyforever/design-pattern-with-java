package com.wx.decorator.battercake;

/**
 * @program: design-pattern-with-java
 * @description:
 * @author: Mr.Wang
 * @create: 2021-05-18 15:50
 **/
public class BaseBattercake extends Battercake{

    @Override
    public String getMst() {
        return "煎饼";
    }

    @Override
    public int getPrice() {
        return 5;
    }
}
