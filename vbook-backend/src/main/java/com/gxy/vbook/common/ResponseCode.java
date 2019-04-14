package com.gxy.vbook.common;

public enum ResponseCode {
    SUCCESS(0, "SUCCESS"),
    ERROR(1, "ERROR"),
    NEED_LOGIN(10, "NEED_LOGIN"),
    USER_NOT_EXIST(11, "USER_NOT_EXIST"),
    BLANCE_NOT_ENOUGH(12,"BLANCE_NOT_ENOUGH"),
    NOT_ADMIN(3,"NOT_ADMIN"),
    ILLEGAL_ARGUMENT(2, "ILLEGAL_ARGUMENT");

    private final int code;
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
