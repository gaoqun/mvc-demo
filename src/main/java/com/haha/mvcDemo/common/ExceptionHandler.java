package com.haha.mvcDemo.common;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaige on 2018/1/11.
 * 封装异常类型
 */
public class ExceptionHandler implements HandlerExceptionResolver{
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        Map<String,Object> map = new HashMap<>();
        map.put("exception",ex);

        if (ex instanceof BizException){
            return new ModelAndView("biz_exception",map);
        }else if (ex instanceof SystemException){
            return new ModelAndView("sys_exception",map);
        }else {
            return new ModelAndView("undefined_exception",map);
        }
    }
}
