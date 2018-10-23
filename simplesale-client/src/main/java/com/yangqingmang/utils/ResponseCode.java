package com.yangqingmang.utils;

/**
 * $DESCRIPTION$
 *
 * @author yangqingmang
 * @version 1.0
 * @date Create in 2018/10/4 下午12:56
 */
public enum ResponseCode {
    SUCCESS(0, "成功"),
    FAILED(-1, "失败")
    ;

    private Integer code;

    private String message;

    ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
