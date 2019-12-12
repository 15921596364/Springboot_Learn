package com.jianliang.guo.plus.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by jianliang.guo@mtime.com on
 *
 * @Description
 */
@Getter
@Setter
@ToString
public class RestResult<T> {

    private boolean success;
    private String message;
    private T data;

    private RestResult() {}

    public static <T> RestResult<T> newInstance() {
        return new RestResult<>();
    }
}
