package com.haha.mvcDemo.common;

import org.slf4j.LoggerFactory;

/**
 * Created by gaige on 2018/1/10.
 */
public class JsonResponseWrapper {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(JsonResponseWrapper.class);

    //业务正常返回
    public static <T>JsonResponse wrapBizSuccess( T result, String msg) {
        JsonResponse<T> response = new JsonResponse<T>();
        response.setData(result);
        response.setMsg(msg);
        response.setStatus(ResponseStatus.OK);
        response.setCode("200");
        return response;
    }

    //业务返回异常
    public static JsonResponse wrapBizException(Exception e) {
        JsonResponse response = new JsonResponse();
        if (null!=e){
            if (e instanceof BizException){
                response.setStatus(ResponseStatus.BIZ_ERR);
                response.setMsg(e.getMessage());
                log.debug(e.getMessage());
            }else {
                String msg = e.getMessage();
                msg = null!=msg&&!"".equals(msg)?msg:"未知错误！";
                response.setStatus(ResponseStatus.ERR);
                response.setMsg(msg);
                log.debug(msg);
                response.setMsg(msg);
            }
        }
        response.setCode("202");
        return response;
    }
}
