package com.gxy.vbook.common;

/**
 * 返回给前端的响应码
 */
public enum ResponseCode {
    /**
     * 成功
     */
    SUCCESS(0, "SUCCESS"),
    /**
     * 错误
     */
    ERROR(1, "ERROR"),
    /**
     * 需要登录
     */
    NEED_LOGIN(10, "NEED_LOGIN"),
    /**
     * 用户不存在
     */
    USER_NOT_EXIST(11, "USER_NOT_EXIST"),
    /**
     * 余额不足
     */
    BLANCE_NOT_ENOUGH(12,"BLANCE_NOT_ENOUGH"),
    /**
     * 不是管理员
     */
    NOT_ADMIN(3,"NOT_ADMIN"),
    /**
     * 非法参数异常
     */
    ILLEGAL_ARGUMENT(2, "ILLEGAL_ARGUMENT");

    /**
     * 返回码
     */
    private final int code;
    /**
     * 返回描述
     */
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return desc;
    }

}
