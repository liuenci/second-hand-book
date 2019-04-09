package com.gxy.vbook.service;

import com.gxy.vbook.common.ServerResponse;

public interface OrderService {

    ServerResponse pay(int userId);
}
