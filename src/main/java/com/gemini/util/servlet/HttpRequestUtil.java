package com.gemini.util.servlet;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

/**
 * 提供对Http请求的解析方法
 * @author KingDom
 */
public class HttpRequestUtil {

    /**
     * 获取客户端的请求ip
     * @param request
     * @return
     */
    public static String getRequestIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-client-ip");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        // 多级反向代理
        if (null != ip && !"".equals(ip.trim())) {
            StringTokenizer st = new StringTokenizer(ip, ",");
            if (st.countTokens() > 1) {
                return st.nextToken();
            }
        }
        return ip;
    }

    /**
     * 判断是否是ajax请求, 如果是的话, 应该响应一段403的json数据
     * @param request
     * @return
     */
    public static boolean isAjax(HttpServletRequest request) {
        return request.getHeader("X-Requested-With") != null;
    }

}
