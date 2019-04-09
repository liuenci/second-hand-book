package com.gxy.vbook.service.impl;

import com.gxy.vbook.common.Const;
import com.gxy.vbook.common.ResponseCode;
import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.dao.UserMapper;
import com.gxy.vbook.pojo.User;
import com.gxy.vbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public ServerResponse save(String name, String password) {
        User user = userMapper.selectByName(name);
        if (user != null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
        }
        User insertUser = new User();
        insertUser.setName(name);
        insertUser.setPassword(password);
        insertUser.setBalance(0D);
        int result = userMapper.insert(insertUser);
        return ServerResponse.createBySuccess(insertUser);
    }

    @Override
    public ServerResponse login(String name, String password) {
        User user = userMapper.selectByNameAndPassword(name, password);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.USER_NOT_EXIST.getCode(),ResponseCode.USER_NOT_EXIST.getDesc());
        }
        return ServerResponse.createBySuccess(user);
    }

    @Override
    public ServerResponse update(int id, String phone, String email) {
        User u = new User();
        u.setId(id);
        u.setPhone(phone);
        u.setEmail(email);
        int result= userMapper.updateByPrimaryKeySelective(u);
        return ServerResponse.createBySuccess();
    }

    @Override
    public ServerResponse profile() {
        Integer userId = Integer.parseInt(redisTemplate.opsForValue().get(Const.CURRENT_USER));
        if (userId == null) {
            ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        User user = userMapper.selectByPrimaryKey(userId);
        return ServerResponse.createBySuccess(user);
    }
}
