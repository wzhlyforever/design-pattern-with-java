package org.itstack.demo.design.store.impl;

import com.alibaba.fastjson.JSON;
import java.util.Map;
import org.exmaple.demo.design.card.IQiYiCardService;
import org.itstack.demo.design.store.ICommodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: design-pattern-with-java
 * @description:
 * @author: Mr.Wang
 * @create: 2022-02-28 15:06
 **/
public class CardCommodityService implements ICommodity {

    private Logger logger = LoggerFactory.getLogger(CardCommodityService.class);

    // 模拟注入
    private IQiYiCardService iQiYiCardService = new IQiYiCardService();

    public void sendCommodity(String uid, String commodityId, String bid, Map<String, String> extMap) throws Exception {

        String mobile = queryUserMobile(uid);
        iQiYiCardService.grantToken(mobile, bid);
        logger.info("请求参数[爱奇艺兑换卡] => uId：{} commodityId：{} bizId：{} extMap：{}", uid, commodityId, bid,
                JSON.toJSON(extMap));
        logger.info("测试结果[爱奇艺兑换卡]：success");
    }

    private String queryUserMobile(String uId) {
        return "15200101232";
    }
}
