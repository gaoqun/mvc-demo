package com.haha.mvcDemo.service.impl;

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

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by gaige on 2017/12/8.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private WeChatUserMapper weChatUserMapper;

    private Logger logger = LoggerFactory.getLogger("userModify");

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
//                    throw new BizException("添加失败！");
                    logger.info("用户重复注册！手机号******"+phoneNumber+"************");
                    id=-1;//重复添加用户
                }else {
                    User user = new User();
                    user.setMoney(userVo.getMoney());
                    user.setUserName(userVo.getUserName());
                    user.setNickName(userVo.getNickName());
                    user.setTelephone(userVo.getTelephone());
                    user.setPwd("123456");
                    id = userMapper.insertSelective(user);
                }
                break;
            case WeChatUser:
                //1，测试需要，根据名字查询
                String weChatUserName = userVo.getUserName();
                WeChatUser queryWeChatUser = weChatUserMapper.selectByUsername(weChatUserName);
                if (null!=queryWeChatUser){
                    logger.info("该微信用户已经注册过 用户名：*********"+weChatUserName+"************");
                    id = -1;
                }else {
                    WeChatUser weChatUser = new WeChatUser();
                    weChatUser.setMoney(userVo.getMoney());
                    weChatUser.setOpenId(1);
                    weChatUser.setUnionId("10001");
                    weChatUser.setUsername(userVo.getUserName());
                    id = weChatUserMapper.insert(weChatUser);
                }
                break;
        }
        return id;
    }

    /**
     * 登录：微信 手机号登录
     */
    @Override
    public UserVo login(int openId) {
        //微信登录，检测有没有绑定手机号，没有绑定手机号先绑定手机号
        User user = userMapper.selectByOpenId(openId);
        if (null!=user){
            //已经合并
            UserVo userVo = new UserVo();
            userVo.setMoney(user.getMoney());
            userVo.setTelephone(user.getTelephone());
            return userVo;
        }else {
            logger.info("合并******微信/手机号******账号");
            WeChatUser weChatUser = weChatUserMapper.selectByPrimaryKey(openId);
            if (weChatUser!=null){
                user = userMapper.selectByPrimaryKey(2);
                BigDecimal weChatMoney = weChatUser.getMoney();
                user.setCombineAccountFlag(1);
                user.setCombineAccountTime(new Date());
                BigDecimal phoneUserMoney = user.getMoney();
                double money1 = phoneUserMoney.add(weChatMoney).doubleValue();
                logger.info("合并******money="+money1);
                user.setMoney(new BigDecimal(Double.toString(money1)));
                user.setOpenId(openId);
                userMapper.updateByPrimaryKey(user);
            }
            return null;
        }


    }

}
