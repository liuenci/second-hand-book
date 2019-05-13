package com.gxy.vbook.service.impl;

import com.gxy.vbook.common.Const;
import com.gxy.vbook.common.PageResponse;
import com.gxy.vbook.common.ResponseCode;
import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.dao.UserMapper;
import com.gxy.vbook.pojo.User;
import com.gxy.vbook.service.UserService;
import com.gxy.vbook.utils.BigDecimalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 用户注册
     * @param name
     * @param password
     * @param email
     * @param phone
     * @return
     */
    @Override
    public ServerResponse save(String name, String password,String email, String phone) {
        User user = userMapper.selectByName(name);
        if (user != null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
        }
        User insertUser = new User();
        insertUser.setName(name);
        insertUser.setPassword(password);
        insertUser.setBalance(0D);
        insertUser.setRole(1);
        insertUser.setEmail(email);
        insertUser.setPhone(phone);
        insertUser.setLevel(0D);
        insertUser.setCommentNumber(0);
        insertUser.setTotalScore(0);
        int result = userMapper.insert(insertUser);
        return ServerResponse.createBySuccess(insertUser);
    }

    /**
     * 用户登录
     * @param name
     * @param password
     * @return
     */
    @Override
    public ServerResponse login(String name, String password) {
        User user = userMapper.selectByNameAndPassword(name, password);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.USER_NOT_EXIST.getCode(),ResponseCode.USER_NOT_EXIST.getDesc());
        }else {
            if (user.getRole() == Const.UserStatus.LOCK) {
                return ServerResponse.createByErrorMessage("用户已被锁定,无法登录");
            }
        }
        return ServerResponse.createBySuccess(user);
    }

    /**
     * 更新用户信息
     * @param id
     * @param phone
     * @param email
     * @param password
     * @return
     */
    @Override
    public ServerResponse update(int id, String phone, String email, String password) {
        User u = new User();
        u.setId(id);
        u.setPhone(phone);
        u.setEmail(email);
        u.setPassword(password);
        int result= userMapper.updateByPrimaryKeySelective(u);
        return ServerResponse.createBySuccess(u);
    }

    /**
     * 查看用户信息
     * @return
     */
    @Override
    public ServerResponse profile() {
        Integer userId = Integer.parseInt(redisTemplate.opsForValue().get(Const.CURRENT_USER));
        if (userId == null) {
            ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        User user = userMapper.selectByPrimaryKey(userId);
        return ServerResponse.createBySuccess(user);
    }

    /**
     * 模糊查询所有用户集合
     * @param name
     * @return
     */
    @Override
    public PageResponse findUserList(String name) {
        name = new StringBuffer("%").append(name).append("%").toString();
        List<User> list = userMapper.selectUserList(name);
        PageResponse response = new PageResponse();
        response.setTotal(list.size());
        response.setRows(list);
        return response;
    }

    @Override
    public ServerResponse lockOrUnLock(Integer userId, Integer userStatus) {
        User user = userMapper.selectByPrimaryKey(userId);
        if (userStatus == Const.UserStatus.LOCK){
            user.setRole(Const.UserStatus.LOCK);
        } else if (userStatus == Const.UserStatus.UNLOCK) {
            user.setRole(Const.UserStatus.UNLOCK);
        }
        userMapper.updateByPrimaryKey(user);
        return ServerResponse.createBySuccess();
    }

    @Override
    public ServerResponse recharge(Double money) {
        // 拿到当前 redis 中的用户 ID
        Integer userId = Integer.parseInt(redisTemplate.opsForValue().get(Const.CURRENT_USER));
        User user = userMapper.selectByPrimaryKey(userId);
        user.setBalance(BigDecimalUtil.add(user.getBalance(),money).doubleValue());
        userMapper.updateByPrimaryKeySelective(user);
        return ServerResponse.createBySuccess();
    }

    @Override
    public ServerResponse delete(Integer userId) {
        userMapper.deleteByPrimaryKey(userId);
        return ServerResponse.createBySuccess();
    }
}
