package com.haha.mvcDemo.dao.impl;


import com.haha.mvcDemo.common.Pager;
import com.haha.mvcDemo.dao.Idao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class IdaoImpl<T, PK extends Serializable> implements Idao<T, PK> {

    @Autowired(required = false)
    private JdbcTemplate jdbcTemplate;

    @Autowired(required = false)
    private SqlSession sqlSession;

    public SqlSession getSqlSession() {
        return this.sqlSession;
    }

    @Override
    public void save(T entity) {
        sqlSession.insert(entity.getClass().getName() + ".insertSelective", entity);

    }

    @Override
    public void saveOrUpdate(T entity) {
        sqlSession.insert(entity.getClass().getName() + ".saveOrUpdate", entity);

    }

    @Override
    public void save(Class<T> entityClass, Map<String, Object> maps, String operate) {
        int id = sqlSession.insert(entityClass.getName() + "." + operate, maps);
    }

    @Override
    public void deleteByPrimaryKey(Class<T> entityClass, PK pk) {

        sqlSession.delete(entityClass.getName() + ".deleteByPrimaryKey", pk);
    }

    @Override
    public void update(T entity) {

        sqlSession.update(entity.getClass().getName() + ".updateByPrimaryKeySelective", entity);
    }

    @Override
    public void update(Class<T> entityClass, Map<String, Object> maps, String operate) {
        sqlSession.update(entityClass.getName() + "." + operate, maps);
    }

    @Override
    public T findById(Class<T> entityClass, PK pk) {

        return sqlSession.selectOne(entityClass.getName() + ".selectByPrimaryKey",
                pk);
    }

    @Override
    public List<T> findAll(Class<T> entityClass) {
        return sqlSession.selectList(entityClass.getName() + ".findAll");
    }

    @Override
    public Pager<T> findByPage(Class<T> entityClass, int pageNo, int pageSize) {
        return findByPage(entityClass, pageNo, pageSize, null, null);
    }

    @Override
    public void updateOrder(T entity) {
        sqlSession.update(entity.getClass().getName() + ".updateOrder",
                entity);
    }

    @Override
    public T login(T entity) {
        return sqlSession.selectOne(
                entity.getClass().getName() + ".login", entity);
    }

    @Override
    public Pager<T> findByPage(Class<T> entityClass, int pageNo, int pageSize, Object key, String funname) {
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("pageNo", pageNo);
        maps.put("pageSize", pageSize);

        if (key != null) {
            maps.put("key", key);
        }
        String selectKey = entityClass.getName();
        if (funname != null)
            selectKey += "." + funname;
        int totalnum = sqlSession.selectOne(selectKey, maps);
        Pager<T> pager = new Pager<T>();
        pager.setPageSize(pageSize);
        pager.setTotalRecords(totalnum);
        pager.setPageIndex(pageNo);
        pager.prePager();
        return pager;
    }

    @Override
    public Pager<T> findByKey(Class<T> entityClass, Map<String, Object> maps, String operate) {

        Pager<T> pager = new Pager<T>();
        List<T> pageList = sqlSession.selectList(
                entityClass.getName() + operate, maps);
        int totalNum = getTotalNum(entityClass, maps, operate);
        pager.setRecords(pageList);
        pager.setTotalRecords(totalNum);
        return pager;
    }


    @Override
    public int isExist(Class<T> entityClass, Map<String, Object> maps, String operate) {
        int count = 0;
        count = sqlSession
                .selectOne(entityClass.getName() + "." + operate, maps);
        return count;
    }

    @Override
    public T findByParam(Class<T> entityClass, Map<String, Object> maps, String operate) {

        return sqlSession.selectOne(entityClass.getName() + "." + operate, maps);
    }

    @Override
    public List<T> findAllByKey(Class<T> entityClass, Map<String, Object> maps, String operate) {

        return sqlSession.selectList(entityClass.getName() + "." + operate, maps);

    }

    @Override
    public Map<String, Object> findMapByKey(Class<T> entityClass, Map<String, Object> maps, String operate) {

        return sqlSession.selectOne(entityClass.getName() + "." + operate, maps);

    }

    @Override
    public List<Map<String, Object>> findMapListByKey(Class<T> entityClass, Map<String, Object> maps, String operate) {

        return sqlSession.selectList(entityClass.getName() + "." + operate, maps);
    }

    // 多条件的查询 得到总和
    private int getTotalNum(Class<T> entityClass, Map<String, Object> maps,
                            String operate) {
        int totalNum = 0;
        totalNum = sqlSession.selectOne(
                entityClass.getName() + "." + operate + "Total", maps);
        return totalNum;
    }

    private int getTotalNum(Class<T> entityClass, Object key) {
        int totalNum = 0;
        if (key != null) {
            totalNum = sqlSession.selectOne(
                    entityClass.getName() + ".findTotal", key);
        } else {
            totalNum = sqlSession.selectOne(
                    entityClass.getName() + ".findTotal");
        }
        return totalNum;
    }


}

