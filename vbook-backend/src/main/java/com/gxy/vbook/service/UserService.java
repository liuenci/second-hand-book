package com.gxy.vbook.service;

import com.gxy.vbook.common.PageResponse;
import com.gxy.vbook.common.ServerResponse;

/**
 * 用户接口
 */
public interface UserService {
    /**
     * 用户注册
     * @param name
     * @param password
     * @param email
     * @param phone
     * @return
     */
    ServerResponse save(String name, String password, String email, String phone);

    /**
     * 用户登录
     * @param name
     * @param password
     * @return
     */
    ServerResponse login(String name, String password);

    /**
     * 更新用户信息
     * @param id
     * @param phone
     * @param email
     * @param password
     * @return
     */
    ServerResponse update(int id, String phone, String email,String password);

    /**
     * 用户的信息查询
     * @return
     */
    ServerResponse profile();

    /**
     * 管理员
     * 模糊查询用户信息
     * @param name
     * @return
     */
    PageResponse findUserList(String name);

    /**
     * 充值
     * @param money
     * @return
     */
    ServerResponse recharge(Double money);

    ServerResponse lockOrUnLock(Integer userId,Integer userStatus);

    ServerResponse delete(Integer userId);
}
