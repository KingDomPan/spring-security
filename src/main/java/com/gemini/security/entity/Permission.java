package com.gemini.security.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.gemini.util.format.TreeFormat;

/**
 * 权限表/菜单表
 */
@Entity
@Table(name = "T_ACL_PERMISSION")
public class Permission implements TreeFormat<Permission, Long>, Cloneable {

    @Id
    @Column(name = "MENU_ID")
    private Long id;

    /** 操作中文名称. */
    @Column(name = "NAME_CN")
    private String name;
    
    /**操作英文名称**/
    @Column(name = "NAME_EN")
    private String nameEn;
    
    @Column(name = "enabled")
    private int enabled;
    
    @Column(name = "IMAGE_URL")
    private String imageUrl;
    
    @Column(name = "MENU_TYPE")
    private int menuType;
    
    /** 功能编码. */
    @Column(name = "PERMISSION_CODE")
    private String code;

    @Column(name = "MENU_INDEX")
    private Integer order;

    /** 描述. */
    @Column(name = "MENU_DESC")
    private String description;

    @Column(name = "URL")
    private String pageUrl;

    @Column(name = "PARENT_ID")
    private Long parentId;
    
    /** 下级权限. */
    @Transient
    private List<Permission> children = new ArrayList<Permission>();

    public Permission() {
    }

    public Permission(long id) {
        this.id = id;
    }

    public void addChildren(Permission child) {
        if (child != null && !this.children.contains(child)) {
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
        Permission other = (Permission) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        } else if (!this.id.equals(other.id))
            return false;
        return true;
    }

    public List<Permission> getChildren() {
        return this.children;
    }

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getOrder() {
        return this.order;
    }

    public String getPageUrl() {
        return this.pageUrl;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public String getNameEn() {
        return this.nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public int getEnabled() {
        return this.enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getMenuType() {
        return this.menuType;
    }

    public void setMenuType(int menuType) {
        this.menuType = menuType;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }

    public void setChildren(List<Permission> children) {
        this.children = children;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
