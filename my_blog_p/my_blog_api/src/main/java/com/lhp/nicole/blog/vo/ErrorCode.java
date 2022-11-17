package com.lhp.nicole.blog.vo;

public enum ErrorCode {
    PARAMS_INVALID(1001,"invalid params"),
    TOKEN_INVALID(1002,"invalid token"),
    NOT_LOGIN(2001, "user not logged in"),
    USER_PWD_NOT_EXIST(2002,"username or password not exist"),
    ACCOUNT_EXIST(2003,"a user with this username already exists"),
    NO_PERMISSION(7001,"user has no permission"),
    SESSION_TIME_OUT(9001,"session time out");

    private int code;
    private String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
