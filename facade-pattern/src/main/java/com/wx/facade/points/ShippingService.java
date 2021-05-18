package com.wx.facade.points;

/**
 * @program: design-pattern-with-java
 * @description: 物流系统
 * @author: Mr.Wang
 * @create: 2021-05-18 12:48
 **/
public class ShippingService {
    public String delivery(GiftInfo giftInfo){
        System.out.println(giftInfo.getName() + "进入物流系统");
        String shippingNo = "666";
        return shippingNo;
    }
}
