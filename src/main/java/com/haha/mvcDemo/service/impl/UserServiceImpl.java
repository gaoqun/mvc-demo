package com.haha.mvcDemo.service.impl;

import com.haha.mvcDemo.common.BizException;
import com.haha.mvcDemo.dao.UserMapper;
import com.haha.mvcDemo.dao.WeChatUserMapper;
import com.haha.mvcDemo.domain.User;
import com.haha.mvcDemo.domain.WeChatUser;
import com.haha.mvcDemo.service.UserService;
import com.haha.mvcDemo.service.UserType;
import com.haha.mvcDemo.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gaige on 2017/12/8.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    private WeChatUserMapper weChatUserMapper;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserVo getWeChatUserById(UserType userType, String id) {
        UserVo userVo = null;
        switch (userType)
        {
            case PhoneUser:
                User user = userMapper.selectByPrimaryKey(Integer.valueOf(id));
                if (null!=user)
                userVo = new UserVo(user.getId().toString(),user.getUserName(),user.getTelephone(),user.getMoney(),user.getCreateTime());
                break;
            case WeChatUser:
                WeChatUser weChatUser = weChatUserMapper.selectByPrimaryKey(Integer.valueOf(id));
                if (null!=weChatUser)
                userVo = new UserVo(weChatUser.getOpenId().toString(),weChatUser.getUsername(),weChatUser.getMoney());
                break;
        }
        if (null==userVo){
            logger.debug("没有获取到该用户！****用户ID="+id);
        }
        return userVo;
    }

    @Override
    public int addUser(UserType userType, UserVo userVo) {
        int id=0;
        switch (userType)
        {
            case PhoneUser:
                String phoneNumber = userVo.getTelephone();
                User selectUser = userMapper.selectByPhoneNumber(phoneNumber);
                if (null!=selectUser){
                    throw new BizException("添加失败！");
                }
                User user = new User();
                user.setMoney(userVo.getMoney());
                user.setUserName(userVo.getUserName());
                user.setNickName(userVo.getNickName());
                user.setTelephone(userVo.getTelephone());
                user.setPwd("123456");
                id = userMapper.insertSelective(user);
                break;
            case WeChatUser:
                WeChatUser weChatUser = new WeChatUser();
                weChatUser.setMoney(userVo.getMoney());
                weChatUser.setUsername(userVo.getUserName());
                id = weChatUserMapper.insert(weChatUser);
                break;
        }
        return id;
    }
}
