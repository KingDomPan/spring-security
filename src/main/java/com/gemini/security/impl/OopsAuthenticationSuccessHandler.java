package com.gemini.security.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.util.Assert;

public class OopsAuthenticationSuccessHandler implements
        AuthenticationSuccessHandler, InitializingBean {

    private String defaultTargetUrl = null;
    private boolean useForward = true;

    public String getDefaultTargetUrl() {
        return defaultTargetUrl;
    }

    public void setDefaultTargetUrl(String defaultTargetUrl) {
        this.defaultTargetUrl = defaultTargetUrl;
    }

    public boolean isUseForward() {
        return useForward;
    }

    public void setUseForward(boolean useForward) {
        this.useForward = useForward;
    }

    public void onAuthenticationSuccess(HttpServletRequest request,
            HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        if (this.useForward) {
            request.getRequestDispatcher(this.defaultTargetUrl).forward(request, response);
        } else {
            response.sendRedirect(this.defaultTargetUrl);
        }
    }

    public void afterPropertiesSet() throws Exception {
        Assert.notNull(this.defaultTargetUrl, "The default target url must be set");
    }

}
