package com.gxy.vbook.service;

import com.gxy.vbook.common.ServerResponse;

public interface UserService {

    ServerResponse save(String name, String password, String email, String phone);

    ServerResponse login(String name, String password);

    ServerResponse update(int id, String phone, String email);

    ServerResponse profile();

    ServerResponse list();
}
