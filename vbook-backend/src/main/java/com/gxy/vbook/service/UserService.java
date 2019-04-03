package com.gxy.vbook.service;

import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.pojo.User;

public interface UserService {

    ServerResponse save(String name, String password);
}
