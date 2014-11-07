package com.gemini.security.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

public class OopsLogoutHandler implements LogoutSuccessHandler {

    private String defaultLogoutUrl = null;
    private boolean useForward = true;

    public String getDefaultLogoutUrl() {
        return defaultLogoutUrl;
    }

    public void setDefaultLogoutUrl(String defaultLogoutUrl) {
        this.defaultLogoutUrl = defaultLogoutUrl;
    }

    public boolean isUseForward() {
        return useForward;
    }

    public void setUseForward(boolean useForward) {
        this.useForward = useForward;
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request,
            HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        if (this.useForward) {
            request.getRequestDispatcher(this.defaultLogoutUrl).forward(
                    request, response);
        } else {
            response.sendRedirect(this.defaultLogoutUrl);
        }
    }
}
