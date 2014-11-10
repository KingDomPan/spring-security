package com.gemini.template;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.util.Assert;

import com.gemini.support.Container;
import com.gemini.support.CrudHandler;
import com.gemini.support.PageSpliter;

/**
 * 实现Dao<T>的接口方法, 并提供数据库操作接口给子类
 * @author KingDom
 * @param <T>
 */
@SuppressWarnings("unchecked")
public abstract class BaseDao<T> implements Dao<T> {
    protected Class<T> clazz;
    @Autowired
    protected CrudHandler crudHandler;
    @Autowired
    protected PageSpliter pageSpliter;
    @Autowired
    protected HibernateTemplate hibernateTemplate;
    @Autowired
    protected JdbcTemplate jdbcTemplate;

    public BaseDao() {
        super();
        this.clazz = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /********* CRDU ******************/
    @Override
    public Serializable save(T entity) {
        Assert.notNull(entity, "要保存的对象不能为空");
        return this.hibernateTemplate.save(entity);
    }
    
    @Override
    public void update(T entity) {
        Assert.notNull(entity, "要更新的对象不能为空");
        this.hibernateTemplate.update(entity);
    }
    
    @Override
    public void delete(T entity) {
        Assert.notNull(entity, "要删除的对象不能为空");
        this.hibernateTemplate.delete(entity);
    }
    
    public void deleteById(Serializable id) {
        Assert.notNull(id, "要删除的对象主键不能为空");
        T t = this.getOneById(id);
        this.hibernateTemplate.delete(t);
    }
    
    @Override
    public T getOneById(Serializable id) {
        Assert.notNull(id, "要查找的对象主键不能为空");
        return this.hibernateTemplate.get(this.clazz, id);
    }
    
    @Override
    public T loadOneById(Serializable id) {
        Assert.notNull(id, "要查找的对象主键不能为空");
        return this.hibernateTemplate.load(this.clazz, id);
    }

    public Container<T> getByPage(int pageNo, int pageSize, String where) {
        return this.pageSpliter.getListByPage(this.clazz, pageNo, pageSize, where);
    }
    
    /********* CRDU ******************/

    public Class<T> getClazz() {
        return this.clazz;
    }

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    public CrudHandler getCrudHandler() {
        return this.crudHandler;
    }

    public void setCrudHandler(CrudHandler crudHandler) {
        this.crudHandler = crudHandler;
    }

    public PageSpliter getPageSpliter() {
        return this.pageSpliter;
    }

    public void setPageSpliter(PageSpliter pageSpliter) {
        this.pageSpliter = pageSpliter;
    }

    public HibernateTemplate getHibernateTemplate() {
        return this.hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return this.jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getClazzName() {
        return this.getClazz().getName();
    }

}
