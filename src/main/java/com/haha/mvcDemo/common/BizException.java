package com.haha.mvcDemo.common;

/**
 * Created by gaige on 2018/1/10.
 */
public class BizException extends BaseException{
    
    public BizException() {
        super();
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }
}
