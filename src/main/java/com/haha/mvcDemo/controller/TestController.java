package com.haha.mvcDemo.controller;

import com.haha.mvcDemo.service.UserService;
import com.haha.mvcDemo.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gaige on 2018/1/9.
 */
@RestController
public class TestController {

    @Autowired
    private UserService service;

    @ResponseBody
    @RequestMapping("test")
    public String test(){
        return "index";
    }

    @ResponseBody
    @RequestMapping("user/{userId}")
    public UserVo getUserInfo(@PathVariable("userId")String userId){
        return service.getUserById(userId);
    }


    @ResponseBody
    @RequestMapping("user")
    public String test1(){
        return "user";
    }
}
