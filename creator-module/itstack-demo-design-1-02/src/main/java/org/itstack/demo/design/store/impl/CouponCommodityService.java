package org.itstack.demo.design.store.impl;

import com.alibaba.fastjson.JSON;
import java.util.Map;
import org.exmaple.demo.design.coupon.CouponResult;
import org.exmaple.demo.design.coupon.CouponService;
import org.itstack.demo.design.store.ICommodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: design-pattern-with-java
 * @description:
 * @author: Mr.Wang
 * @create: 2022-02-28 14:42
 **/
public class CouponCommodityService implements ICommodity {

    Logger logger = LoggerFactory.getLogger(CouponCommodityService.class);
    CouponService couponService = new CouponService();

    public void sendCommodity(String uid, String commodityId, String bid, Map<String, String> extMap) throws Exception {


        final CouponResult couponResult = couponService.sendCoupon(uid, commodityId, bid);
        logger.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uid, commodityId, bid,
                JSON.toJSON(extMap));
        logger.info("测试结果[优惠券]：{}", JSON.toJSON(couponResult));

        if (!"0000".equals(couponResult.getCode())) {
            throw new RuntimeException(couponResult.getInfo());
        }
    }
}
