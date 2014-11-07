package com.gemini.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.gemini.dao.RolePermissionDao;
import com.gemini.security.entity.Permission;
import com.gemini.security.entity.Role;
import com.gemini.service.RolePermissionService;

@Component("rolePermissionServiceImpl")
public class RolePermissionServiceImpl implements RolePermissionService {

    private RolePermissionDao rolePermissionDao;

    @Override
    public List<Map<Role, Permission>> getRoleMappingPermission() {
        return this.rolePermissionDao.getRoleMappingPermission();
    }

    public RolePermissionDao getRolePermissionDao() {
        return this.rolePermissionDao;
    }

    @Resource(name = "rolePermissionDaoImpl")
    public void setRolePermissionDao(RolePermissionDao rolePermissionDao) {
        this.rolePermissionDao = rolePermissionDao;
    }
}
