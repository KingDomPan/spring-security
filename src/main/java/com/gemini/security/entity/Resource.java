package com.gemini.security.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.gemini.util.format.TreeFormat;

/**
 * 资源实体类.
 */
@Entity
@Table(name = "T_ACL_RESOURCE")
public class Resource implements TreeFormat<Resource, Long> {

    @Id
    @Column(name = "ACL_RESOURCE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "RESOURCE_TYPE", nullable = false)
    private Integer type;
    
    @Column(name = "RESOURCE_KEY", nullable = false)
    private String key;

    @Transient
    private String name;

    @Column(name = "ACL_USERGROUP_ID", nullable = false)
    private Long userGroupId;

    @Transient
    private List<Resource> children = new ArrayList<Resource>();

    public void addChildren(Resource child) {
        if (child != null) {
            this.children.add(child);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Resource other = (Resource) obj;
        if (this.key == null) {
            if (other.key != null)
                return false;
        } else if (!this.key.equals(other.key))
            return false;
        if (this.type == null) {
            if (other.type != null)
                return false;
        } else if (!this.type.equals(other.type))
            return false;
        return true;
    }

    public List<Resource> getChildren() {
        return this.children;
    }

    public Long getId() {
        return this.id;
    }

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public Long getParentId() {
        return null;
    }

    public Integer getType() {
        return this.type;
    }

    public Long getUserGroupId() {
        return this.userGroupId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    public void setChildren(List<Resource> children) {
        if (children != null) {
            this.children = children;
        } else {
            this.children.clear();
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Integer code) {
        this.type = code;
    }

    public void setUserGroupId(Long userGroupId) {
        this.userGroupId = userGroupId;
    }
}
