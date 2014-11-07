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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Where;

import com.gemini.entity.Code;
import com.gemini.entity.Region;

/**
 * 用户实体类.
 */
@Entity
@Table(name = "T_ACL_USER")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 在用. */
    public static final int STATUS_ENABLED = 1;
    /** 注销. */
    public static final int STATUS_DISABLED = 2;
    /** 锁定. */
    public static final int STATUS_LOCKED = 3;

    public static final int SUPER_ADMIN = 1;

    public static final int ISLEADER_YES = 1;
    public static final int ISLEADER_NO = 0;
    
    @Id
    @Column(name = "ACL_USER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** 用户名. */
    @Column(name = "LOGIN_NAME", unique = true, nullable = false, length = 45)
    private String name;

    /** 昵称. */
    @Column(name = "ALIAS")
    private String alias;

    /** 密码(使用MD5加密). */
    @Column(name = "PASSWORD", nullable = false, length = 45)
    private String password;

    /** 用户状态 1、在用 2、注销 3、锁定. */
    @Column(name = "STATUS", nullable = false)
    private Integer statusValue = User.STATUS_ENABLED;

    @Transient
    private Code status = Code.newCodeDef("T_ACL_USER", "STATUS");

    /**
     * 用户类型： 1、超级管理员2、监控人员 3、大客户经理 4、大客户本身.
     */
    @Column(name = "USER_TYPE", nullable = false)
    private Integer typeValue = 2;

    @Transient
    private Code type = Code.newCodeDef("T_ACL_USER", "USER_TYPE");

    /** 邮箱. */
    @Column(name = "E_MAIL")
    private String email;

    /** 电话号码. */
    @Column(name = "TELEPHONE")
    private String phoneNo;

    /** 描述信息. */
    @Column(name = "DESCRIPTION", length = 255)
    private String description;

    /** 关联角色信息. */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "T_ACL_USER_ROLE", joinColumns = @JoinColumn(name = "ACL_USER_ID", referencedColumnName = "ACL_USER_ID"), inverseJoinColumns = @JoinColumn(name = "ACL_ROLE_ID", referencedColumnName = "ACL_ROLE_ID"))
    private Set<Role> roles = new HashSet<Role>();

    /** 关联用户组信息. */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "T_ACL_USER_USERGROUP", joinColumns = @JoinColumn(name = "ACL_USER_ID", referencedColumnName = "ACL_USER_ID"), inverseJoinColumns = @JoinColumn(name = "ACL_USERGROUP_ID", referencedColumnName = "ACL_USERGROUP_ID"))
    @Where(clause = "GROUP_TYPE = 1 AND STATUS = 1")
    @OrderBy("orderIndex asc")
    private List<UserGroup> userGroups = new ArrayList<UserGroup>();

    @Column(name = "CREATE_USER_ID", nullable = false)
    private Long creatorId = new Long(0);

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "INSERT_TIME", nullable = false)
    private Date insertTime;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATE_TIME", nullable = false)
    private Date updateTime;

    @Transient
    private Set<Permission> permissions = null;

    @Column(name = "OFFICE_PHONE")
    private String officePhone;

    @Column(name = "IS_PARTNER")
    private Integer isPartnerValue = 1;

    @Transient
    private Code isPartner = Code.newCodeDef("T_ACL_USER", "IS_PARTNER");

    @Column(name = "SEX")
    private Integer sexValue = 1;

    @Transient
    private Code sex = Code.newCodeDef("T_ACL_USER", "SEX");

    @Column(name = "PID")
    private String pid;

    @Column(name = "PINGYIN")
    private String pingyin;

    @Column(name = "BIRTHDAY")
    private String birthday;

    @ManyToOne
    @JoinColumn(name = "REGION_ID")
    private Region region;

    /** 组织机构. */
    @OneToOne
    @JoinColumn(name = "ORG_ID")
    @Fetch(FetchMode.JOIN)
    private UserGroup organization;

    @Column(name = "ORDER_INDEX")
    private Long orderIndex = 1L;

    @Temporal(TemporalType.DATE)
    @Column(name = "PASSWORD_UPDATE_DATE")
    private Date passwordUpdateDate;

    /** 领导标识 */
    @Column(name = "IS_LEADER")
    private Integer isLeader = 0;

    /** 服务管理员标识 */
    @Column(name = "IS_SERVICE_MANAGER")
    private Integer isServiceManager = 0;

    /** 预留字段 */
    @Column(name = "ARG1")
    private Integer arg1;

    @Column(name = "ARG2")
    private Integer arg2;

    @Column(name = "ARG3")
    private String arg3;

    @Column(name = "ARG4")
    private String arg4;

    /**
     * 默认构造函数.
     */
    public User() {
    }

    public void addRole(Role role) {
        if (role != null) {
            this.roles.add(role);
        }
    }

    public void addUserGroup(UserGroup group) {
        if (group != null) {
            this.userGroups.add(group);
        }
    }

    public void enable(boolean enabled) {
        this.statusValue = enabled ? User.STATUS_ENABLED : User.STATUS_LOCKED;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        } else if (!this.id.equals(other.id))
            return false;
        return true;
    }

    public String getAlias() {
        return this.alias;
    }

    public Integer getArg1() {
        return this.arg1;
    }

    public Integer getArg2() {
        return this.arg2;
    }

    public String getArg3() {
        return this.arg3;
    }

    public String getArg4() {
        return this.arg4;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public Long getCreatorId() {
        return this.creatorId;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDisplayName() {
        if (StringUtils.isNotEmpty(this.alias)) {
            return this.alias;
        } else {
            return this.name;
        }
    }

    public String getEmail() {
        return this.email;
    }

    public Long getId() {
        return this.id;
    }

    public Date getInsertTime() {
        return this.insertTime;
    }

    public Integer getIsLeader() {
        return this.isLeader;
    }

    public Code getIsPartner() {
        this.isPartner.setValueInt(this.isPartnerValue);
        return this.isPartner;
    }

    public Integer getIsPartnerValue() {
        return this.isPartnerValue;
    }

    public Integer getIsServiceManager() {
        return this.isServiceManager;
    }

    public String getName() {
        return this.name;
    }

    public String getOfficePhone() {
        return this.officePhone;
    }

    public Long getOrderIndex() {
        return this.orderIndex;
    }

    public UserGroup getOrganization() {
        return this.organization;
    }

    public String getPassword() {
        return this.password;
    }

    public Date getPasswordUpdateDate() {
        return this.passwordUpdateDate;
    }

    public Set<Permission> getPermissions() {
        if (this.permissions == null) {
            this.permissions = new HashSet<Permission>();
            for (Role role : this.roles) {
                this.permissions.addAll(role.getPermissions());
            }
        }
        return this.permissions;
    }

    public String getPhoneNo() {
        return this.phoneNo;
    }

    public String getPid() {
        return this.pid;
    }

    public String getPingyin() {
        return this.pingyin;
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

    public Set<Role> getRoles() {
        return this.roles;
    }

    public Code getSex() {
        this.sex.setValueInt(this.sexValue);
        return this.sex;
    }

    public Integer getSexValue() {
        return this.sexValue;
    }

    public Code getStatus() {
        this.status.setValueInt(this.statusValue);
        return this.status;
    }

    public Integer getStatusValue() {
        return this.statusValue;
    }

    public Code getType() {
        this.type.setValueInt(this.typeValue);
        return this.type;
    }

    public Integer getTypeValue() {
        return this.typeValue;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public List<UserGroup> getUserGroups() {
        return this.userGroups;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }

    public boolean isAdmin() {
        return this.typeValue == User.SUPER_ADMIN;
    }

    public boolean isEnable() {
        return this.statusValue == User.STATUS_ENABLED;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setArg1(Integer arg1) {
        this.arg1 = arg1;
    }

    public void setArg2(Integer arg2) {
        this.arg2 = arg2;
    }

    public void setArg3(String arg3) {
        this.arg3 = arg3;
    }

    public void setArg4(String arg4) {
        this.arg4 = arg4;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public void setIsLeader(Integer isLeader) {
        this.isLeader = isLeader;
    }

    public void setIsPartner(Code isPartner) {
        this.isPartner = isPartner;
    }

    public void setIsPartnerValue(Integer isPartnerValue) {
        this.isPartnerValue = isPartnerValue;
        this.isPartner.setValueInt(isPartnerValue);
    }

    public void setIsServiceManager(Integer isServiceManager) {
        this.isServiceManager = isServiceManager;
    }

    public void setName(String userName) {
        this.name = userName;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public void setOrderIndex(Long orderIndex) {
        this.orderIndex = orderIndex;
    }

    public void setOrganization(UserGroup organization) {
        this.organization = organization;
    }

    public void setPassword(String password) {
        this.password = password;
        this.passwordUpdateDate = new Date();
    }

    public void setPasswordUpdateDate(Date passwordUpdateDate) {
        this.passwordUpdateDate = passwordUpdateDate;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setPingyin(String pingyin) {
        this.pingyin = pingyin;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles.clear();

        if (roles != null) {
            for (Role role : roles) {
                this.roles.add(role);
            }
        }
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setSex(Code sex) {
        this.sex = sex;
    }

    public void setSexValue(Integer sexValue) {
        this.sexValue = sexValue;
        this.sex.setValueInt(sexValue);
    }

    public void setStatus(Code code) {
        this.statusValue = code.getValueInt();
    }

    public void setStatusValue(Integer status) {
        this.statusValue = status;
        this.status.setValueInt(status);
    }

    public void setType(Code type) {
        this.type = type;
    }

    public void setTypeValue(Integer typeValue) {
        this.typeValue = typeValue;
        this.type.setValueInt(typeValue);
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setUserGroups(List<UserGroup> userGroups) {
        this.userGroups.clear();
        if (userGroups != null) {
            for (UserGroup userGroup : userGroups) {
                this.userGroups.add(userGroup);
            }
        }
    }
}
