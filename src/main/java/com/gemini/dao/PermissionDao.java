package com.gemini.dao;

import java.util.List;

import com.gemini.security.entity.Permission;
import com.gemini.template.Dao;

public interface PermissionDao extends Dao<Permission> {
    List<Permission> getAllPermission();
}
