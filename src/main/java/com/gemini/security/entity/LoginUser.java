package com.gemini.security.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

import com.gemini.entity.Region;
import com.gemini.util.format.TreeBuilder;


/**
 * 登录用户信息.
 */
@SuppressWarnings({ "deprecation", "serial" })
public class LoginUser implements UserDetails {
    private Long id;
    private String name;
    private String displayName;
    private String password;
    private String ip;
    private Integer type;
    private int statusValue = -1;

    /** 登录时间. */
    private Date loginTime;
    private boolean admin = false;

    private UserGroup organization;
    private Set<Role> roles = new HashSet<Role>();
    private List<UserGroup> userGroups = new ArrayList<UserGroup>();
    private Set<Permission> permissions = new HashSet<Permission>();
    private Set<GrantedAuthority> grantedAuthorities = null;

    /** 授权的页面. */
    private Set<String> authorizedPages = new HashSet<String>();

    private Region region;

    public void addPermission(Collection<Permission> permissions) {
        for (Permission permission : permissions) {
            addPermission(permission);
        }
    }

    public void addPermission(Permission permission) {
        if (permission != null && permission.getPageUrl() != null) {
            this.authorizedPages.add(permission.getPageUrl());
        }
        this.permissions.add(permission);
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public Long getId() {
        return this.id;
    }

    public String getIp() {
        return this.ip;
    }

    public Date getLoginTime() {
        return this.loginTime;
    }

    public long getLoginTimeMilis() {
        return this.loginTime.getTime();
    }

    public String getName() {
        return this.name;
    }

    public UserGroup getOrganization() {
        return this.organization;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public List<Long> getPermissionIds() {
        List<Long> permissionIds = new ArrayList<Long>();
        for (Permission permission : getPermissions()) {
            permissionIds.add(permission.getId());
        }
        return permissionIds;
    }

    public Set<Permission> getPermissions() {
        return this.permissions;
    }

    public List<Permission> getPermissionTree() {
        return TreeBuilder.newTreeBuilder(Permission.class, Long.class)
                .buildToTreeList(this.permissions);
    }

    public Region getRegion() {
        return this.region;
    }

    public Collection<Resource> getResources(ResourceDefine def) {
        Set<Resource> resources = new HashSet<Resource>();

        for (UserGroup userGroup : getUserGroups()) {
            resources.addAll(userGroup.getResources(def));
        }
        if (this.organization != null) {
            resources.addAll(this.organization.getResources(def));
        }
        return resources;
    }

    public List<Long> getRoleIds() {
        List<Long> roleIds = new ArrayList<Long>();
        for (Role role : getRoles()) {
            roleIds.add(role.getId());
        }
        return roleIds;
    }

    public Set<Role> getRoles() {
        return this.roles;
    }

    public Integer getType() {
        return this.type;
    }

    public int getStatusValue() {
        return this.statusValue;
    }

    public void setStatusValue(int statusValue) {
        this.statusValue = statusValue;
    }

    public List<Long> getUserGroupIds() {
        List<Long> userGroupIds = new ArrayList<Long>();
        for (UserGroup userGroup : getUserGroups()) {
            userGroupIds.add(userGroup.getId());
        }
        return userGroupIds;
    }

    public List<UserGroup> getUserGroups() {
        return this.userGroups;
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isAdmin() {
        return this.admin;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.statusValue == User.STATUS_ENABLED;
    }

    /**
     * Spring Security关键方法
     * 用来获取已认证的用户的权限, 用GrantedAuthority来表示
     * 每个GrantedAuthority要是一个字符串, 这里用pageUrl来表示
     */
    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        if (this.grantedAuthorities == null) {
            this.grantedAuthorities = new HashSet<GrantedAuthority>();
            for (Role role : this.roles) {
                if (StringUtils.isNotEmpty(role.getName())) {
                    grantedAuthorities.add(new GrantedAuthorityImpl(role.getName()));
                }
            }
        }
        return this.grantedAuthorities;
    }

    public boolean isPageAuthorized(String pageUrl) {
        for (String authorizedPage : authorizedPages) {
            if (authorizedPage.startsWith(pageUrl)) {
                return true;
            }
        }
        return isAdmin();
    }

    /**
     * 用户不能修改已分配的用户组信息.
     * @param userGroup
     * @return
     */
    public boolean isUserGroupEditable(UserGroup userGroup) {
        return !userGroups.contains(userGroup);
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrganization(UserGroup organization) {
        this.organization = organization;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPermissions(Set<Permission> permissions) {
        addPermission(permissions);
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setUserGroups(List<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }
    
    @Override
    public String toString() {
        return "LoginUser [id=" + id + ", name=" + name + ", displayName="
                + displayName + ", password=" + password + "]";
    }
}
