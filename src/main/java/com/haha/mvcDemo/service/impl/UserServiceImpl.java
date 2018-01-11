package com.haha.mvcDemo.service.impl;

import com.haha.mvcDemo.dao.UserMapper;
import com.haha.mvcDemo.domain.User;
import com.haha.mvcDemo.service.UserService;
import com.haha.mvcDemo.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gaige on 2017/12/8.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserVo getUserById(String id) {
        User user = userMapper.selectByPrimaryKey(Integer.valueOf(id));
        return new UserVo(user.getId().toString(),user.getUserName(),user.getTelephone(),user.getNickName());
    }
}
