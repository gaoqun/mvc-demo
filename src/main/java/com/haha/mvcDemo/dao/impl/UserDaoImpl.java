package com.haha.mvcDemo.dao.impl;

import com.haha.mvcDemo.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by gaige on 2018/1/10.
 */
@Repository
public class UserDaoImpl implements com.haha.mvcDemo.dao.UserMapper {

    @Autowired
    SqlSession sqlSession;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sqlSession.delete(User.class.getName() + ".deleteByPrimaryKey", id);
    }

    @Override
    public int insert(User record) {
        return sqlSession.insert(User.class.getName() + ".insert", record);
    }

    @Override
    public int insertSelective(User record) {
        return sqlSession.insert(User.class.getName() + ".insertSelective", record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return sqlSession.selectOne(User.class.getName() + ".selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return sqlSession.update(User.class.getName() + ".updateSelective", record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return sqlSession.update(User.class.getName() + ".updateByPrimaryKey", record);
    }

    @Override
    public User selectByPhoneNumber(String phoneNumber) {
        return sqlSession.selectOne(User.class.getName()+".selectUserByPhoneNumber",phoneNumber);
    }

    @Override
    public User selectByOpenId(Integer openId) {
        return sqlSession.selectOne(User.class.getName()+".selectByOpenId",openId);
    }
}
