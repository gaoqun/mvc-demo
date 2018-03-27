package com.haha.mvcDemo.dao.impl;

import com.haha.mvcDemo.dao.CommodityDao;
import com.haha.mvcDemo.domain.Commodity;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommodityDaoImpl implements CommodityDao{
    @Autowired
    private SqlSession sqlSession;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Commodity record) {
        return 0;
    }

    @Override
    public int insertSelective(Commodity record) {
        return 0;
    }

    @Override
    public Commodity selectByPrimaryKey(Integer id) {
        return sqlSession.selectOne(Commodity.class.getName()+".selectByPrimaryKey",id);
    }

    @Override
    public List<Commodity> selectByName(String name) {
        return sqlSession.selectList(Commodity.class.getName()+".selectByName",name);
    }

    @Override
    public int updateByPrimaryKeySelective(Commodity record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Commodity record) {
        return 0;
    }
}
