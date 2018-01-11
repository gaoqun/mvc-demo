package com.haha.mvcDemo.dao.impl;

import com.haha.mvcDemo.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by gaige on 2018/1/10.
 */
@Repository
public class UserMapper implements com.haha.mvcDemo.dao.UserMapper {

    @Autowired
    SqlSession sqlSession;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(User record) {
        return 0;
    }

    @Override
    public int insertSelective(User record) {
        return 0;
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return sqlSession.selectOne(User.class.getName() + ".selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }
}
