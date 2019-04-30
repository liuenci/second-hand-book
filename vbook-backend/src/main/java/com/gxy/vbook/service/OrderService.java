package com.gxy.vbook.service;

import com.gxy.vbook.common.PageResponse;
import com.gxy.vbook.common.ServerResponse;

/**
 * 订单接口
 */
public interface OrderService {
    /**
     * 支付
     * @param userId
     * @return
     */
    ServerResponse pay(int userId);

    /**
     * 订单列表
     * @param userId
     * @return
     */
    PageResponse list(int userId);

    /**
     * 某个订单下的订单子表列表
     * @param orderNo
     * @return
     */
    PageResponse orderItemList(String orderNo);

    /**
     * 通过订单编号查询订单子表
     * @param orderId
     * @return
     */
    ServerResponse item(String orderId);

    /**
     * 模糊查询订单列表
     * @param orderNo
     * @return
     */
    PageResponse findOrderList(String orderNo);


}
