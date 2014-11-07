package com.gemini.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gemini.template.BaseDao;
import com.gemini.dao.PermissionDao;
import com.gemini.security.entity.Permission;

@Component("permissionDaoImpl")
public class PermissionDaoImpl extends BaseDao<Permission> implements PermissionDao {

    @Override
    public List<Permission> getAllPermission() {
        return null;
    }
}
