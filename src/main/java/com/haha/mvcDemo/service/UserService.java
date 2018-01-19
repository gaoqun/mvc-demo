package com.haha.mvcDemo.service;

import com.haha.mvcDemo.vo.UserVo;

/**
 * Created by gaige on 2017/12/8.
 */
public interface UserService {

    UserVo getWeChatUserById(UserType userType,String id);

    int addUser(UserType userType,UserVo userVo);

}
