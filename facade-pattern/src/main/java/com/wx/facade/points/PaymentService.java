package com.wx.facade.points;

/**
 * @program: design-pattern-with-java
 * @description: 支付系统
 * @author: Mr.Wang
 * @create: 2021-05-18 12:43
 **/
public class PaymentService {
    public boolean pay (GiftInfo pointsGift) {
        System.out.println("扣减" + pointsGift.getName() + " 积分成功");
      return true;
    }
}
