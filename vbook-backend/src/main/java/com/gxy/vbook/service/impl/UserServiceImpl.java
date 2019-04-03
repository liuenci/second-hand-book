package com.gxy.vbook.service.impl;

import com.gxy.vbook.common.ResponseCode;
import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.dao.UserMapper;
import com.gxy.vbook.pojo.User;
import com.gxy.vbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse save(String name, String password) {
        User user = userMapper.selectByName(name);
        if (user != null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
        }
        User insertUser = new User();
        insertUser.setName(name);
        insertUser.setPassword(password);
        int result = userMapper.insert(insertUser);
        return ServerResponse.createBySuccess(insertUser);
    }
}
