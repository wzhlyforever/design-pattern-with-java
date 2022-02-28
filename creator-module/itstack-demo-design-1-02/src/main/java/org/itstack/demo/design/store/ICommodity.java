package org.itstack.demo.design.store;

import java.util.Map;

/**
 *  定义一个发放奖品的接口 统一入参和出参
 */

public interface ICommodity {

    /**
     * @param uid 用户id
     * @param commodityId   商品id
     * @param bid 业务id
     * @param extMap 商品的额外数据
     * @throws Exception
     */
    void sendCommodity(String uid, String commodityId, String bid, Map<String, String> extMap) throws Exception;

}
