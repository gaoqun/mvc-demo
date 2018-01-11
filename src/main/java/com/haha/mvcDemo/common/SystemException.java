package com.haha.mvcDemo.common;

/**
 * Created by gaige on 2018/1/10.
 */
public class SystemException extends BaseException{

    public SystemException() {
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemException(Throwable cause) {
        super(cause);
    }
}
