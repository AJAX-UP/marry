package com.xcgn.marry.business.shiroconfig;

import com.xcgn.marry.business.model.Permission;
import com.xcgn.marry.business.model.Role;
import com.xcgn.marry.business.model.User;
import com.xcgn.marry.business.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * create by ajaxgo on 2019/11/25
 **/
public class PhoneRealm extends AuthorizingRealm {

    @Resource
    UserService userService;
    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        PhoneToken token = null;
        // 如果是PhoneToken，则强转，获取phone；否则不处理。
        if(authenticationToken instanceof PhoneToken){
            token = (PhoneToken) authenticationToken;
        }else{
            return null;
        }
        String phone = (String) token.getPrincipal();
        User user = userService.findByPhone(phone);
        if (user == null) {
            try {
                throw new Exception("手机号错误");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new SimpleAuthenticationInfo(user, phone, this.getName());
    }
    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User User = (User) principals.getPrimaryPrincipal();
        for (Role role : User.getRoleList()) {
            authorizationInfo.addRole(role.getName());
            for (Permission p : role.getPermissions()) {
                authorizationInfo.addStringPermission(p.getPerms());
            }
        }
        return authorizationInfo;
    }

    @Override
    public boolean supports(AuthenticationToken var1){
        return var1 instanceof PhoneToken;
    }
}
