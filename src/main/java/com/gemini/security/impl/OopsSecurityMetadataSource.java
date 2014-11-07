package com.gemini.security.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import com.gemini.security.entity.Permission;
import com.gemini.security.entity.Role;
import com.gemini.service.RolePermissionService;

/**
 * 获取"资源表"中的系统中的资源定义
 * @author KingDom
 */
public class OopsSecurityMetadataSource implements
        FilterInvocationSecurityMetadataSource {

    private PathMatcher um = new AntPathMatcher();
    private RolePermissionService rolePermissionService;
    private static Map<String, Collection<ConfigAttribute>> resourceMap;
    
    /**
     * 用uri进行简单的处理之后, 从资源表中获取对应资源 再获取对应的角色, 以SecurityConfig返回给系统进行授权
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object)
            throws IllegalArgumentException {
        loadResourceDefine();
        
        Iterator<String> ita = resourceMap.keySet().iterator();
        while(ita.hasNext()){
            String i = ita.next();
            System.out.println(i);
            for(ConfigAttribute ca : resourceMap.get(i))
                System.out.println(" -----" + ca.getAttribute());
        }
        
        // 用户请求的url
        String url = ((FilterInvocation) object).getRequestUrl();
        int firstQuestionMarkIndex = url.indexOf("?");
        if (firstQuestionMarkIndex != -1) {
            url = url.substring(0, firstQuestionMarkIndex);
        }
        Iterator<String> it = resourceMap.keySet().iterator();
        while (it.hasNext()) {
            String permissionUrl = it.next();
            if (this.um.match(permissionUrl, url)) {
                return resourceMap.get(permissionUrl);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    public RolePermissionService getRolePermissionService() {
        return this.rolePermissionService;
    }

    @Resource(name = "rolePermissionServiceImpl")
    public void setRolePermissionService(
            RolePermissionService rolePermissionService) {
        this.rolePermissionService = rolePermissionService;
    }

    public void loadResourceDefine() {
        if (resourceMap == null) {
            resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
            List<Map<Role, Permission>> rps = rolePermissionService
                    .getRoleMappingPermission();
            Collection<ConfigAttribute> eachConfigAttributes = null;
            for (Map<Role, Permission> rp : rps) {
                Iterator<Entry<Role, Permission>> it = rp.entrySet().iterator();
                while (it.hasNext()) {
                    Entry<Role, Permission> e = it.next();
                    Role r = e.getKey();
                    Permission p = e.getValue();
                    String roleName = r.getName();
                    String url = p.getPageUrl();
                    ConfigAttribute ca = new SecurityConfig(roleName);
                    if (resourceMap.containsKey(url)) {
                        eachConfigAttributes = resourceMap.get(url);
                        eachConfigAttributes.add(ca);
                    } else {
                        eachConfigAttributes = new ArrayList<ConfigAttribute>();
                        eachConfigAttributes.add(ca);
                        resourceMap.put(url, eachConfigAttributes);
                    }
                }
            }
        }
    }

}
