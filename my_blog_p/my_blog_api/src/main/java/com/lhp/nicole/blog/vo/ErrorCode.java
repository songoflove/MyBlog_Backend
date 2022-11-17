package com.lhp.nicole.blog.vo;

public enum ErrorCode {
    PARAMS_INVALID(1001,"invalid params"),
    USER_PWD_NOT_EXIST(2002,"username or password not exist"),
    NO_PERMISSION(7001,"user has no permission"),
    SESSION_TIME_OUT(9001,"session time out"),
    NO_LOGIN(2001, "user not logged in");

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
