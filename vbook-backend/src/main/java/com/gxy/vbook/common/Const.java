package com.gxy.vbook.common;

/**
 * 常量类
 */
public class Const {
    // 当前登录用户
    public static final String CURRENT_USER = "currentUser";
    // 当前登录管理员
    public static final String CURRENT_ADMIN = "currentAdmin";

    /**
     * 角色接口
     */
    public interface Role {
        // 普通用户的角色为 1
        int ROLE_USER = 1;
        // 管理员的角色为 0
        int ROLE_ADMIN = 0;
    }
}
