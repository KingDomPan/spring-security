package com.gemini.template;

import java.lang.reflect.ParameterizedType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.gemini.support.CrudHandler;
import com.gemini.support.PageSpliter;

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
