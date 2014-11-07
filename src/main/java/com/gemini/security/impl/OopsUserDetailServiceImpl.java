package com.gemini.security.impl;

import javax.annotation.Resource;

import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.gemini.dao.UserDao;
import com.gemini.security.entity.LoginUser;
import com.gemini.security.entity.Role;
import com.gemini.security.entity.User;
import com.gemini.security.entity.UserGroup;

/**
 * 自定义实现用户验证接口
 * @author KingDom
 */
public class OopsUserDetailServiceImpl implements UserDetailsService {

    private UserDao userDao = null;

    public UserDao getUserDao() {
        return userDao;
    }

    @Resource(name = "userDaoImpl")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Assert.notNull(username, "用户名不允许为空");
        User user = userDao.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("非法用户");
        }
        if (!user.isEnable()) {
            throw new DisabledException("用户不可用");
        }
        LoginUser loginUser = null;
        loginUser = new LoginUser();
        // 用户基本信息
        loginUser.setType(user.getTypeValue());//用户类型
        loginUser.setId(user.getId());
        loginUser.setName(user.getName());
        loginUser.setPassword(user.getPassword());
        loginUser.setOrganization(user.getOrganization());//用户的组织
        loginUser.setDisplayName(user.getDisplayName());
        loginUser.setStatusValue(user.getStatusValue());//很重要, 严重用户是否被能用
        // 加入角色和用户组信息
        user.getRoles().size();//hibernate级联查询 获取用户的角色权限
        user.getUserGroups().size();//hibernate级联查询 获取用户的安全权限的所属组织
        // 用户权限信息
        loginUser.setRoles(user.getRoles());//设置用户角色
        loginUser.setUserGroups(user.getUserGroups());//设置用户安全组
        loginUser.setAdmin(user.isAdmin());//是否是管理员
        loginUser.setPermissions(user.getPermissions());//通过user.roles.获取用户所有的权限

        if (user.getOrganization() != null) {//获取组织的权限(1对1的映射)
            for (Role role : user.getOrganization().getRoles()) {
                loginUser.addPermission(role.getPermissions());
            }
            //合并(安全概念的userGroup和业务上的userGroup)
            if (!loginUser.getUserGroups().contains(user.getOrganization())) {
                loginUser.getUserGroups().add(user.getOrganization());
            }
        }
        for (Role role : user.getRoles()) {
            loginUser.addPermission(role.getPermissions());
        }
        
        for (UserGroup userGroup : user.getUserGroups()) {
            userGroup.getResources().size();
            for (Role role : userGroup.getRoles()) {
                loginUser.addPermission(role.getPermissions());
                loginUser.getRoles().add(role);
            }
        }
        return loginUser;
    }

}
