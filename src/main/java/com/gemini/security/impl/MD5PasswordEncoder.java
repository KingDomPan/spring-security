package com.gemini.security.impl;

import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.util.StringUtils;

import com.gemini.util.MD5Coder;

@SuppressWarnings("deprecation")
public class MD5PasswordEncoder implements PasswordEncoder {

    private MD5Coder coder = new MD5Coder();

    @Override
    public String encodePassword(String rawPass, Object salt) {
        if (StringUtils.isEmpty(rawPass)) {
            return "";
        }
        return coder.getMD5ofStr(rawPass);
    }

    @Override
    public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
        String afterCoder = this.encodePassword(rawPass, salt);
        return encPass.equals(afterCoder)
                || encodePassword(encodePassword(encPass, salt), salt).equals(
                        afterCoder);
    }

}
