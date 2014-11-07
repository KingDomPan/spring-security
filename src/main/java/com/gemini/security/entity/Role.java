package com.gemini.security.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.gemini.util.format.TreeBuilder;


/**
 * 角色实体类.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "T_ACL_ROLE")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ACL_ROLE_ID")
    private Long id;

    /** 角色名. */
    @Column(name = "ROLE_NAME", nullable = false, unique = true)
    private String name;

    /** 描述信息. */
    @Column(name = "DESCRIPTION")
    private String description;

    /** 角色状态. */
    @Column(name = "ENABLED")
    private Integer enabled = 1;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "T_ACL_ROLE_PERMISSION", joinColumns = { @JoinColumn(name = "ACL_ROLE_ID") }, inverseJoinColumns = { @JoinColumn(name = "ACL_PERMISSION_ID") })
    @Fetch(FetchMode.SUBSELECT)
    private Set<Permission> permissions = new HashSet<Permission>();

    @Column(name = "CREATE_USER_ID", nullable = false)
    private Long creatorId = new Long(0);

    @ManyToMany
    @JoinTable(name = "T_ACL_USER_ROLE", joinColumns = { @JoinColumn(name = "ACL_ROLE_ID") }, inverseJoinColumns = { @JoinColumn(name = "ACL_USER_ID") })
    @OrderBy("orderIndex asc")
    private List<User> users = new ArrayList<User>();

    @ManyToMany
    @JoinTable(name = "T_ACL_USERGROUP_ROLE", joinColumns = { @JoinColumn(name = "ACL_ROLE_ID") }, inverseJoinColumns = { @JoinColumn(name = "ACL_USERGROUP_ID") })
    @OrderBy("orderIndex asc")
    private List<UserGroup> userGroups = new ArrayList<UserGroup>();
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "INSERT_TIME", nullable = false)
    protected Date insertTime;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATE_TIME", nullable = false)
    protected Date updateTime;

    public Role() {
    }

    public Role(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Role other = (Role) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        } else if (!this.id.equals(other.id))
            return false;
        return true;
    }

    public Long getCreatorId() {
        return this.creatorId;
    }

    public String getDescription() {
        return this.description;
    }

    public Long getId() {
        return this.id;
    }

    public Date getInsertTime() {
        return this.insertTime;
    }

    public String getName() {
        return this.name;
    }

    public List<Permission> getPermissionAsTree() {
        return TreeBuilder.newTreeBuilder(Permission.class, Long.class)
                .buildToTreeList(getPermissionCopy());
    }

    public Set<Permission> getPermissionCopy() {
        Set<Permission> copy = new HashSet<Permission>();
        try {
            for (Permission permission : getPermissions()) {
                Permission newPermission = new Permission();
                newPermission.setCode(permission.getCode());
                newPermission.setDescription(permission.getDescription());
                newPermission.setName(permission.getName());
                newPermission.setPageUrl(permission.getPageUrl());
                newPermission.setOrder(permission.getOrder());
                newPermission.setParentId(permission.getParentId());
                newPermission.setId(permission.getId());
                copy.add(newPermission);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return copy;
    }

    public Set<Permission> getPermissions() {
        return this.permissions;
    }

    public Integer getStatusValue() {
        return this.enabled;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public List<UserGroup> getUserGroups() {
        return this.userGroups;
    }

    public List<User> getUsers() {
        return this.users;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public void setName(String roleName) {
        this.name = roleName;
    }

    public void setPermissions(Collection<Permission> permissions) {
        this.permissions.clear();
        for (Permission permission : permissions) {
            permission.getChildren().clear();
            this.permissions.add(permission);
        }
    }

    public void setStatusValue(Integer statusValue) {
        this.enabled = statusValue;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setUserGroups(List<UserGroup> userGroups) {
        this.userGroups.clear();
        this.userGroups.addAll(userGroups);
    }

    public void setUsers(List<User> users) {
        this.users.clear();
        this.users.addAll(users);
    }
}
