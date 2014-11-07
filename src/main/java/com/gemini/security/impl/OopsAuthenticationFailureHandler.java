package com.gemini.security.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.util.Assert;

public class OopsAuthenticationFailureHandler implements AuthenticationFailureHandler, InitializingBean{

    private String defaultFailureUrl = null;
    private boolean useForward = true;
    
    public String getDefaultFailureUrl() {
        return defaultFailureUrl;
    }

    public void setDefaultFailureUrl(String defaultFailureUrl) {
        this.defaultFailureUrl = defaultFailureUrl;
    }

    public boolean isUseForward() {
        return useForward;
    }

    public void setUseForward(boolean useForward) {
        this.useForward = useForward;
    }

    public void afterPropertiesSet() throws Exception {
        Assert.notNull(this.defaultFailureUrl, "The default failure target url must be set");
    }

    public void onAuthenticationFailure(HttpServletRequest request,
            HttpServletResponse response, AuthenticationException authenticationException)
            throws IOException, ServletException {
        if (this.useForward) {
            request.getRequestDispatcher(this.defaultFailureUrl).forward(request, response);
        } else {
            response.sendRedirect(this.defaultFailureUrl);
        }
    }

}
