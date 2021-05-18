package com.wx.facade.points;

/**
 * @program: design-pattern-with-java
 * @description: 积分系统类
 * @author: Mr.Wang
 * @create: 2021-05-18 12:41
 **/
public class QualifyService {
    public boolean isAvailable (GiftInfo giftInfo) {
        System.out.println("校验" + giftInfo.getName() + " 积分资格通过，库存通过");
        return true;
    }


}
