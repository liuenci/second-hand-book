package com.gxy.vbook.service.impl;

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
    public List<User> findAllList() {
        return userMapper.selectList();
    }
}
