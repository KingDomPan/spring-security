package com.gemini.security.entity;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 资源定义.
 */
@Entity
@Table(name = "T_ACL_RESOURCE_DEFINE")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class ResourceDefine implements Serializable {
    private static final long serialVersionUID = -1295480526800767589L;

    @Column(name = "BEAN_ID")
    private String beanId;
    
    /** 是否动态资源. */
    @Column(name = "DYNAMIC")
    private Boolean dynamic = true;
    
    @Column(name = "ENTITY_NAME")
    private String entityName;
    
    @Id
    @Column(name = "ACL_RESOURCE_DEFINE_ID")
    private Long id;

    @Column(name = "RESOURCE_NAME")
    private String name;
    @Column(name = "REMARKS")
    private String remarks;

    @Column(name = "TABLE_NAME")
    private String tableName;

    @Column(name = "RESOURCE_CODE")
    private Integer type;

    public String getBeanId() {
        return this.beanId;
    }

    public String getEntityName() {
        return this.entityName;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public String getTableName() {
        return this.tableName;
    }

    public Integer getType() {
        return this.type;
    }

    public Boolean isDynamic() {
        return this.dynamic;
    }

    public void setDynamic(Boolean dynamic) {
        this.dynamic = dynamic;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
