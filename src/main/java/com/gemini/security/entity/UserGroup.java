package com.gemini.security.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Where;

import com.gemini.entity.Region;
import com.gemini.util.format.TreeFormat;
import com.google.common.collect.Lists;

/**
 * 用户组实体类.
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "T_ACL_USERGROUP")
public class UserGroup implements TreeFormat<UserGroup, Long> {

    /** 组织架构. */
    public static final int GROUP_TYPE_PARTY = 2;
    /** 普通用户组. */
    public static final int GROUP_TYPE_NORMAL = 1;
    /** 一级部门. */
    public static final int GROUP_ORG_LEVEL_ONE = 1;

    @Id
    @Column(name = "ACL_USERGROUP_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** 用户组描述信息. */
    @Column(name = "DESCRIPTION")
    private String description;

    /** 用户组名. */
    @Column(name = "GROUP_NAME")
    private String name;

    /** 暂时不用. */
    @Column(name = "GROUP_TYPE")
    private Integer typeValue = 1;

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private UserGroup parent;

    /** 用户组状态: 1、启用 2、禁用. */
    @Column(name = "STATUS")
    private Integer statusValue = 1;

    @ManyToMany
    @JoinTable(name = "T_ACL_USER_USERGROUP", joinColumns = @JoinColumn(name = "ACL_USERGROUP_ID", referencedColumnName = "ACL_USERGROUP_ID"), inverseJoinColumns = @JoinColumn(name = "ACL_USER_ID", referencedColumnName = "ACL_USER_ID"))
    @OrderBy("orderIndex asc")
    @Where(clause = "STATUS = 1")
    private Set<User> users = new HashSet<User>();

    @OneToMany(mappedBy = "parent", orphanRemoval = true)
    @OrderBy("orderIndex asc,name asc")
    private List<UserGroup> children = new ArrayList<UserGroup>();

    @OneToMany(mappedBy = "userGroupId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resource> resources = new ArrayList<Resource>();

    @ManyToMany
    @JoinTable(name = "T_ACL_USERGROUP_ROLE", joinColumns = @JoinColumn(name = "ACL_USERGROUP_ID", referencedColumnName = "ACL_USERGROUP_ID"), inverseJoinColumns = @JoinColumn(name = "ACL_ROLE_ID", referencedColumnName = "ACL_ROLE_ID"))
    private List<Role> roles = new ArrayList<Role>();

    @Column(name = "CREATE_USER_ID", nullable = true)
    private Long creatorId = new Long(0);

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "INSERT_TIME", nullable = true)
    protected Date insertTime;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATE_TIME", nullable = true)
    protected Date updateTime;

    @Column(name = "GROUP_FULL_NAME")
    private String groupFullName;

    @Column(name = "ORDER_INDEX")
    private Long orderIndex = 1L;

    @ManyToOne
    @JoinColumn(name = "REGION_ID")
    private Region region;

    /** 部门级别 **/
    @Column(name = "ORG_LEVEL")
    private Integer orgLevel;

    @Transient
    private boolean parentChanged = false;

    public UserGroup() {
    }

    public void addChildren(UserGroup child) {
        if (child != null) {
            this.children.add(child);
        }
    }

    public void addUser(User user) {
        if (user != null) {
            this.users.add(user);
        }
    }

    public boolean containResource(Resource resource) {
        return this.resources.contains(resource);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserGroup other = (UserGroup) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        } else if (!this.id.equals(other.id))
            return false;
        return true;
    }

    public List<UserGroup> getChildren() {
        return this.children;
    }

    public Long getCreatorId() {
        return this.creatorId;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDisplayName() {
        if (StringUtils.isNotEmpty(this.groupFullName)) {
            return this.groupFullName;
        } else {
            return this.name;
        }
    }

    public String getGroupFullName() {
        return this.groupFullName;
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

    public Long getOrderIndex() {
        return this.orderIndex;
    }

    public Integer getOrgLevel() {
        return this.orgLevel;
    }

    public UserGroup getParent() {
        return this.parent;
    }

    public Long getParentId() {
        Long parentId = null;
        if (this.parent != null) {
            parentId = this.parent.getId();
        }
        return parentId;
    }

    public Region getRegion() {
        return this.region;
    }

    public List<Resource> getResources() {
        return this.resources;
    }

    public List<Resource> getResources(ResourceDefine def) {
        List<Resource> assignedResources = Lists.newArrayList();
        for (Resource resource : getResources()) {
            if (resource.getType().equals(def.getType())) {
                assignedResources.add(resource);
            }
        }
        return assignedResources;
    }

    public List<Role> getRoles() {
        return this.roles;
    }

    public Integer getStatusValue() {
        return this.statusValue;
    }

    public Integer getTypeValue() {
        return this.typeValue;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public Set<User> getUsers() {
        return this.users;
    }

    public void grant(Resource resource) {
        if (!containResource(resource)) {
            this.resources.add(resource);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }

    public boolean isParentChanged() {
        return this.parentChanged;
    }

    public boolean isParty() {
        return this.typeValue == UserGroup.GROUP_TYPE_PARTY;
    }

    public void removeChildren(UserGroup child) {
        Iterator<UserGroup> it = getChildren().iterator();
        while (it.hasNext()) {
            if (child.getId().equals(it.next().getId())) {
                it.remove();
                break;
            }
        }
    }

    public void revoke(Resource resource) {
        this.resources.remove(resource);
    }

    public void setChildren(List<UserGroup> children) {
        if (children != null) {
            this.children = children;
        } else {
            this.children.clear();
        }
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGroupFullName(String groupFullName) {
        this.groupFullName = groupFullName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public void setName(String groupName) {
        this.name = groupName;
    }

    public void setOrderIndex(Long orderIndex) {
        this.orderIndex = orderIndex;
    }

    public void setOrgLevel(Integer orgLevel) {
        this.orgLevel = orgLevel;
    }

    public void setParent(UserGroup parent) {
        if (this.parent != null && parent != null
                && this.parent.getId().equals(parent.getId())) {
            this.parentChanged = false;
        } else {
            this.parentChanged = true;
        }
        this.parent = parent;
    }

    public void setParentChanged(boolean parentChanged) {
        this.parentChanged = parentChanged;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @SuppressWarnings("unchecked")
    public void setResources(ResourceDefine def, List<Resource> resources) {
        List<Resource> resToUse = getResources(def);
        if (resources == null) {
            resources = Lists.newArrayList();
        }
        Collection<Resource> resToRemove = CollectionUtils.subtract(resToUse, resources);
        Collection<Resource> resToAdd = CollectionUtils.subtract(resources, resToUse);
        for (Resource res : resToRemove) {
            this.resources.remove(res);
        }
        for (Resource res : resToAdd) {
            res.setUserGroupId(this.id);
            this.resources.add(res);
        }
    }

    public void setRoles(Collection<Role> roles) {
        this.roles.clear();
        if (roles != null) {
            for (Role role : roles) {
                this.roles.add(role);
            }
        }
    }

    public void setStatusValue(Integer status) {
        this.statusValue = status;
    }

    public void setTypeValue(Integer groupType) {
        this.typeValue = groupType;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setUsers(Set<User> users) {
        if (users != null) {
            this.users = users;
        } else {
            this.users.clear();
        }
    }

}
