package com.wx.facade.points;

/**
 * @program: design-pattern-with-java
 * @description: 门面模式对外只提供兑换礼物的exchange方法
 * @author: Mr.Wang
 * @create: 2021-05-18 12:51
 **/
public class GiftFacadeService {
    private QualifyService qualifyService = new QualifyService();
    private PaymentService paymentService = new PaymentService();
    private ShippingService shippingService = new ShippingService();


    public void exchange(GiftInfo giftInfo){
        if(qualifyService.isAvailable(giftInfo)){
            if(paymentService.pay(giftInfo)){
                String shippingNo = shippingService.delivery(giftInfo);
                System.out.println("物流系统下单成功，物流单号是：" +shippingNo);
            }
        }
    }

}
