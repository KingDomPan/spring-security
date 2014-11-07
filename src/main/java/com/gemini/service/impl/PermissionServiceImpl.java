package com.gemini.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gemini.security.entity.Permission;
import com.gemini.service.PermissionService;

@Component("permissionServiceImpl")
public class PermissionServiceImpl implements PermissionService {

    @Override
    public List<Permission> getAllPermission() {
        return null;
    }

}
