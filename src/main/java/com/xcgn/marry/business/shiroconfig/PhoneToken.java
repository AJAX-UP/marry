package com.xcgn.marry.business.shiroconfig;

import org.apache.shiro.authc.HostAuthenticationToken;
import org.apache.shiro.authc.RememberMeAuthenticationToken;

import java.io.Serializable;

/**
 * create by ajaxgo on 2019/11/25
 **/
public class PhoneToken implements HostAuthenticationToken, RememberMeAuthenticationToken {

    // 手机号码
    private String phone;
    private boolean rememberMe;
    private String host;

    @Override
    public Object getPrincipal() {
        return phone;
    }

    @Override
    public Object getCredentials() {
        return phone;
    }

    public PhoneToken() { this.rememberMe = false; }

    public PhoneToken(String phone) { this(phone, false, null); }

    public PhoneToken(String phone, boolean rememberMe) { this(phone, rememberMe, null); }

    public PhoneToken(String phone, boolean rememberMe, String host) {
        this.phone = phone;
        this.rememberMe = rememberMe;
        this.host = host;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String getHost() {
        return host;
    }

    @Override
    public boolean isRememberMe() {
        return rememberMe;
    }
}
