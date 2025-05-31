package com.gamer.common.result;

import lombok.Data;

import java.io.Serializable;

/**
 * Result returned by controllers
 * @param <T>
 */
@Data
public class Result<T> implements Serializable {

    private Integer code; // 1 - success; otherwise fail
    private String msg; // error message
    private T data;

    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.code = 1;
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<T>();
        result.data = data;
        result.code = 1;
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<T>();
        result.msg = msg;
        result.code = 0;
        return result;
    }
}
