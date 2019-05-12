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
        /**
         * 普通用户的角色为 1
         */
        int ROLE_USER = 1;
        /**
         * 管理员的角色为 0
         */
        int ROLE_ADMIN = 0;
    }
    public interface UserStatus {
        /**
         * 锁定用户为 2
         */
        int LOCK = 2;
        /**
         * 解锁用户为 1
         */
        int UNLOCK = 1;
    }
    public enum BookStatus {
        ON_SALE(1,"在售"),
        OUT_SALE(0,"售出");
        private int code;
        private String desc;
        BookStatus(int code,String desc){
            this.code = code;
            this.desc = desc;
        }
        public Integer getCode(){
            return code;
        }
        public String getDesc(){
            return desc;
        }
    }

}
