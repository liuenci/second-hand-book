package com.gxy.vbook.service;

import com.gxy.vbook.common.ServerResponse;

public interface CartService {

    ServerResponse list(int userId);

    ServerResponse add(int bookId,int count,int userId);
}
