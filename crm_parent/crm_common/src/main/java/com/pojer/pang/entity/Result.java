package com.pojer.pang.entity;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: pojer
 * @Date: 2021/05/12/下午 8:03
 * @Description:
 */
@Data
public class Result {

    private boolean success;

    private int code;

    private String message;

    public Result(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

}
