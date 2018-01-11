package com.haha.mvcDemo.common;

import org.slf4j.LoggerFactory;

/**
 * Created by gaige on 2018/1/10.
 */
public class JsonResponseWapper {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(JsonResponseWapper.class);

    //业务正常返回
    public static <T> void wrapBizSuccess(JsonResponse<T> response, T result, String msg) {
        response.setData(result);
        response.setMsg(msg);
        response.setStatus(ResponseStatus.OK);
        response.setCode("200");
    }

    //业务返回异常
    public static void wrapBizException(JsonResponse response, Exception e, String errorMsg) {
        response.setMsg(errorMsg);
        if (null!=e){
            if (e instanceof BizException){
                response.setStatus(ResponseStatus.BIZ_ERR);
                response.setMsg(e.getMessage());
            }
        }
        response.setCode("202");
        log.debug(errorMsg);
    }
}
