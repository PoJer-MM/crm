package com.pojer.pang.entity;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: pojer
 * @Date: 2021/05/12/下午 8:03
 * @Description:公共返回码
 */
public enum ResultCode {

    SUCCESS(true,2001,"操作成功"),
    FAIL(false,1001,"操作失败"),
    UNAUTHENTICATED(false,1002,"您还未登陆"),
    UNAUTHORISE(false,1003,"权限不足"),
    SERVER_ERROR(false,9999,"系统繁忙，请稍后重试！");

    boolean success;

    int code;

    String message;

    ResultCode(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public boolean success(){
        return success;
    }

    public int code(){
        return code;
    }

    public String message(){
        return message;
    }
}
