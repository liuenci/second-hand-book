package com.gxy.vbook.service;

import com.gxy.vbook.common.PageResponse;
import com.gxy.vbook.common.ServerResponse;

public interface BookService {
    ServerResponse save(int id, String name, Double price);

    PageResponse findList(String name);
}
