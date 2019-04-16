package com.gxy.vbook.service;

import com.gxy.vbook.common.PageResponse;
import com.gxy.vbook.common.ServerResponse;

public interface CartService {

    PageResponse list(int userId);

    ServerResponse add(int bookId,int count,int userId);
}
