package com.haha.mvcDemo.dao.impl;

import com.haha.mvcDemo.dao.WeChatUserMapper;
import com.haha.mvcDemo.domain.WeChatUser;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by gaige on 2018/1/19.
 */
@Repository
public class WeChatUserDaoImpl implements WeChatUserMapper{

    @Autowired
    private SqlSession sqlSession;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sqlSession.delete(WeChatUser.class.getName()+".delete",id);
    }

    @Override
    public int insert(WeChatUser record) {
        return sqlSession.insert(WeChatUser.class.getName()+".insert",record);
    }

    @Override
    public int insertSelective(WeChatUser record) {
        return sqlSession.insert(WeChatUser.class.getName()+".insertSelective",record);
    }

    @Override
    public WeChatUser selectByPrimaryKey(Integer id) {
        return sqlSession.selectOne(WeChatUser.class.getName()+".selectByPrimaryKey",id);
    }

    @Override
    public WeChatUser selectByUsername(String username) {
        return sqlSession.selectOne(WeChatUser.class.getName()+".selectByUserName",username);
    }

    @Override
    public int updateByPrimaryKeySelective(WeChatUser record) {
        return sqlSession.update(WeChatUser.class.getName()+".updateSelective",record);
    }

    @Override
    public int updateByPrimaryKey(WeChatUser record) {
        return sqlSession.update(WeChatUser.class.getName()+".update",record);
    }
}
