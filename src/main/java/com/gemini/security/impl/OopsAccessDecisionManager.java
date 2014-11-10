package com.gemini.security.impl;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * 定义资源与资源的访问规范
 * 直接实现AccessDecisionManager, 不需要投票器的决策
 * @author KingDom
 */
public class OopsAccessDecisionManager implements AccessDecisionManager {

    @Override
    public void decide(Authentication authentication, Object object,
            Collection<ConfigAttribute> configAttributes)
            throws AccessDeniedException, InsufficientAuthenticationException {
        System.out.println("OopsAccessDecisionManager.Authentication");
        if (configAttributes == null) {
            return;
        }
        /**受保护的资源需要的访问权限*/
        Iterator<ConfigAttribute> ite = configAttributes.iterator();

        while (ite.hasNext()) {
            ConfigAttribute ca = ite.next();
            System.out.println("ca--------" + ca.getAttribute());
            String needRole = ((SecurityConfig) ca).getAttribute();
            for (GrantedAuthority ga : authentication.getAuthorities()) {
                System.out.println(ga.getAuthority() + "        GrantedAuthority");
                if (needRole.trim().equals(ga.getAuthority().trim())) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("无访问权限");
    }

    @Override
    public boolean supports(ConfigAttribute configAttributes) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

}
