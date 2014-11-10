package com.gemini.util.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Spring Security工具类
 * @author KingDom
 */
public class SecurityUtil {

    /**
     * 获取安全认证对象
     * @return
     */
    public static UserDetails getUserDetails() {
        UserDetails userDetails = null;
        SecurityContext sc = SecurityContextHolder.getContext();
        Authentication ac = sc.getAuthentication();
        if (ac != null) {
            userDetails = (UserDetails) ac.getPrincipal();
        }
        return userDetails;
    }

    public static String getUserName() {
        return getUserDetails().getUsername();
    }

    public static boolean isLogin() {
        return getUserName() != null;
    }

}
