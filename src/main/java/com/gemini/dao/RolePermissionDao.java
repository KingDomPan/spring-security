package com.gemini.dao;

import java.util.List;
import java.util.Map;

import com.gemini.security.entity.Permission;
import com.gemini.security.entity.Role;

public interface RolePermissionDao {
    List<Map<Role, Permission>> getRoleMappingPermission();
}
