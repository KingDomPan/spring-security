package com.gemini.service;

import java.util.List;
import java.util.Map;

import com.gemini.security.entity.Permission;
import com.gemini.security.entity.Role;

public interface RolePermissionService {
    List<Map<Role, Permission>> getRoleMappingPermission();
}
