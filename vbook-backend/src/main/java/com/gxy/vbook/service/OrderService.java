package com.gxy.vbook.service;

import com.gxy.vbook.common.ServerResponse;

public interface OrderService {

    ServerResponse pay(int userId);

    ServerResponse list(int userId);

    ServerResponse list();

    ServerResponse item(String orderId);
}
