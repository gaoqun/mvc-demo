package com.haha.mvcDemo.dao;

import com.haha.mvcDemo.domain.WeChatUser;

public interface WeChatUserMapper {
    int deleteByPrimaryKey(Integer openId);

    int insert(WeChatUser record);

    int insertSelective(WeChatUser record);

    WeChatUser selectByPrimaryKey(Integer openId);

    int updateByPrimaryKeySelective(WeChatUser record);

    int updateByPrimaryKey(WeChatUser record);
}