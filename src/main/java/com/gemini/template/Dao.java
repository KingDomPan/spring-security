package com.gemini.template;

import java.io.Serializable;

/**
 * 定义通用CRDU的DAO接口
 * @author KingDom
 * @param <T>
 */
public interface Dao<T> {
    public Serializable save(T entity);

    public T getOneById(Serializable id);

    public void delete(T entity);

    public void update(T entity);

    public T loadOneById(Serializable id);
}
