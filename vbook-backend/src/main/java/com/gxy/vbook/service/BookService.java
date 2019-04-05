package com.gxy.vbook.service;

import com.gxy.vbook.common.ServerResponse;

public interface BookService {
    ServerResponse save(int id, String name, Double price);

    ServerResponse findList(String name);
}
