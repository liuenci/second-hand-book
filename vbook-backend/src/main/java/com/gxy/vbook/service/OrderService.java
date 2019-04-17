package com.gxy.vbook.service;

import com.gxy.vbook.common.PageResponse;
import com.gxy.vbook.common.ServerResponse;

public interface OrderService {

    ServerResponse pay(int userId);

    PageResponse list(int userId);


    PageResponse orderItemList(String orderNo);
    ServerResponse list();

    ServerResponse item(String orderId);


}
