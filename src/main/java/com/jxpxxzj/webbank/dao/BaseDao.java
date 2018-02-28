package com.jxpxxzj.webbank.dao;

import java.util.List;

public interface BaseDao<T, PK> {
    T findById(Class<T> entityClass, PK id);

    List<T> findByHql(String hql, Object[] params);

    void save(T entity);

    void saveOrUpdate(T entity);

}
