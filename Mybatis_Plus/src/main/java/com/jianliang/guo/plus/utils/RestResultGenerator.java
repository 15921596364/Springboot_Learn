package com.jianliang.guo.plus.utils;

import com.alibaba.druid.wall.violation.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jianliang.guo@mtime.com on
 *
 * @Description
 */
public class RestResultGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestResultGenerator.class);

    /**
     * normal
     * @param success
     * @param data
     * @param message
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> getResult(boolean success, T data, String message) {
        RestResult<T> result = RestResult.newInstance();
        result.setSuccess(success);
        result.setData(data);
        result.setMessage(message);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("generate rest result:{}", result);
        }
        return result;
    }

    /**
     * success
     * @param data
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> getSuccessResult(T data) {

        return getResult(true, data, null);
    }

    /**
     * error message
     * @param message error message
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> getErrorResult(String message) {

        return getResult(false, null, message);
    }

    /**
     * error
     * @param error error enum
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> getErrorResult(ErrorCode error) {

        return getErrorResult(error.toString());
    }

    /**
     * success no message
     * @return
     */
    public static RestResult getSuccessResult() {
        return getSuccessResult(null);
    }

    /**
     * success add message
     * @param message
     * @return
     */
    public static RestResult getSuccessResult(String message){
        return getResult(true,null,message);
    }
}
