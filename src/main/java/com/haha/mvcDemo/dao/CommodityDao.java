package com.haha.mvcDemo.dao;

import com.haha.mvcDemo.domain.Commodity;

import java.util.List;

public interface CommodityDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Commodity record);

    int insertSelective(Commodity record);

    Commodity selectByPrimaryKey(Integer id);

    List<Commodity> selectByName(String name);

    int updateByPrimaryKeySelective(Commodity record);

    int updateByPrimaryKey(Commodity record);
}