package org.example.demo.design;

import com.alibaba.fastjson.JSON;
import org.exmaple.demo.design.card.IQiYiCardService;
import org.exmaple.demo.design.coupon.CouponResult;
import org.exmaple.demo.design.coupon.CouponService;
import org.exmaple.demo.design.goods.DeliverReq;
import org.exmaple.demo.design.goods.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: design-pattern-with-java
 * @description:
 * @author: Mr.Wang
 * @create: 2022-02-28 11:40
 **/
public class PriceController {

     
    
    Logger logger = LoggerFactory.getLogger(PriceController.class);
    
    public AwardRes AwardToUser(AwardReq req) {

        String reqJson = JSON.toJSONString(req);

        AwardRes awardRes = null;

        try {
            logger.info("奖品发放开始{}。req:{}", req.getuId(), reqJson);

            if (req.getAwardType() == 1) {
                //发放优惠券
                CouponService couponService = new CouponService();
                CouponResult couponResult = couponService.sendCoupon(req.getuId(), req.getAwardNumber(), req.getBizId());
                if (couponResult.getCode() == "0000") {

                    awardRes = new AwardRes("0000", "奖品发放成功");
                } else {
                    awardRes = new AwardRes("0001", awardRes.getInfo());
                }

            } else if (req.getAwardType() == 2) {
                // 说明发放的是实物商品
                GoodsService goodsService = new GoodsService();
                DeliverReq deliverReq = new DeliverReq();
                deliverReq.setUserName(queryUserName(req.getuId()));
                deliverReq.setUserPhone(queryUserPhoneNumber(req.getuId()));
                deliverReq.setSku(req.getAwardNumber());
                deliverReq.setOrderId(req.getBizId());
                deliverReq.setConsigneeUserName(req.getExtMap().get("consigneeUserName"));
                deliverReq.setConsigneeUserPhone(req.getExtMap().get("consigneeUserPhone"));
                deliverReq.setConsigneeUserAddress(req.getExtMap().get("consigneeUserAddress"));
                Boolean isSuccess = goodsService.deliverGoods(deliverReq);
                if (isSuccess) {
                    awardRes = new AwardRes("0000", "发放成功");
                } else {
                    awardRes = new AwardRes("0001", "发放失败");
                }
            } else if (req.getAwardType() == 3) {
                // 说明发放的是第三张爱奇艺卡
                IQiYiCardService iQiYiCardService = new IQiYiCardService();
                iQiYiCardService.grantToken(queryUserPhoneNumber(req.getuId()), req.getAwardNumber());
                awardRes = new AwardRes("0000", "发放成功");

            }

            logger.info("奖品发放完成{}。", req.getuId());
        } catch (Exception e) {
            logger.error("奖品发放失败{}。req:{}", req.getuId(), reqJson, e);
            awardRes = new AwardRes("0001", e.getMessage());
        }

     return awardRes;
    }


    private String queryUserName(String uId) {
        return "花花";
    }

    private String queryUserPhoneNumber(String uId) {
        return "15200101232";
    }


}
