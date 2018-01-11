package com.haha.mvcDemo.dao;

import com.haha.mvcDemo.common.Pager;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public interface Idao<T, ID extends Serializable> {
    /**
     * 保存数据
     *
     * @param entity
     */
    public void save(T entity);

    /**
     * 保存或更新数据
     * @param entity
     */
    public void saveOrUpdate(T entity);


    /**
     * 按照对象类型保存数据
     *
     * @param entityClass
     * @param maps
     * @param operate
     */
    public void save(Class<T> entityClass, Map<String, Object> maps, String operate);

    /**
     * 删除数据
     *
     * @param pk
     */
    public void deleteByPrimaryKey(Class<T> entityClass, ID pk);

    /**
     * 更新数据
     *
     * @param entity
     */
    public void update(T entity);

    /**
     * 按照对象类型更新数据
     *
     * @param entityClass
     * @param maps
     * @param operate
     */

    public void update(Class<T> entityClass, Map<String, Object> maps, String operate);

    /**
     * ��ѯ ��ID
     *
     * @param pk
     */
    public T findById(Class<T> entityClass, ID pk);

    /**
     * ��ѯȫ����Ϣ
     *
     * @return
     */
    public List<T> findAll(Class<T> entityClass);

    /**
     * ��ҳ��Ϣ
     *
     * @param entityClass
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Pager<T> findByPage(Class<T> entityClass, int pageNo, int pageSize);

    /**
     * ����
     *
     * @param entity
     */
    public void updateOrder(T entity);

    /**
     * ��½
     *
     * @param entity
     * @return
     */
    public T login(T entity);

    /**
     * ��һ�������ķ�ҳ
     *
     * @param entityClass
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */
    public Pager<T> findByPage(Class<T> entityClass, int pageNo, int pageSize, Object key, String funname);

    /**
     * ���������ķ�ҳ
     *
     * @param entityClass
     * @param maps
     * @param operate
     * @return
     */
    public Pager<T> findByKey(Class<T> entityClass, Map<String, Object> maps, String operate);

    /**
     * �ж�ĳ��ֵ�Ƿ����
     *
     * @param entityClass
     * @param maps
     * @param operate
     * @return
     */
    public int isExist(Class<T> entityClass, Map<String, Object> maps, String operate);

    /**
     * ͨ��һ������ȡ����Ӧ�Ķ���
     *
     * @param entityClass
     * @param maps
     * @param operate
     * @return
     */
    public T findByParam(Class<T> entityClass, Map<String, Object> maps, String operate);

    /**
     * �������� ��ѯ��������
     *
     * @param entityClass
     * @param maps
     * @param operate
     * @return
     */
    public List<T> findAllByKey(Class<T> entityClass, Map<String, Object> maps, String operate);

    /**
     * ���map
     *
     * @param entityClass
     * @param maps
     * @param operate
     * @return
     */
    public Map<String, Object> findMapByKey(Class<T> entityClass, Map<String, Object> maps, String operate);

    /**
     * ���maplist
     *
     * @param entityClass
     * @param maps
     * @param operate
     * @return
     */
    public List<Map<String, Object>> findMapListByKey(Class<T> entityClass, Map<String, Object> maps, String operate);



}

