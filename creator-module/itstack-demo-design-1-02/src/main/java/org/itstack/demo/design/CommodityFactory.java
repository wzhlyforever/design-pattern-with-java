package org.itstack.demo.design;

import org.itstack.demo.design.store.ICommodity;
import org.itstack.demo.design.store.impl.CardCommodityService;
import org.itstack.demo.design.store.impl.CouponCommodityService;
import org.itstack.demo.design.store.impl.GoodsCommodityService;

/**
 * @program: design-pattern-with-java
 * @description:
 * @author: Mr.Wang
 * @create: 2022-02-28 15:16
 **/
public class CommodityFactory {

    
    public ICommodity AwardToUserByAwardType (Integer awardType) {

        if (awardType == null) return null;
        if (awardType == 1) return new CouponCommodityService();
        if (2 == awardType) return new GoodsCommodityService();
        if (3 == awardType) return new CardCommodityService();
        throw new RuntimeException("不存在的商品服务类型");
        
    }
}
