package com.carlson.demo.client.shiro.realm;

import com.carlson.demo.dao.model.DemoPermission;
import com.carlson.demo.dao.model.DemoRole;
import com.carlson.demo.dao.model.DemoUser;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.carlson.demo.rpc.api.IDemoAPIService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 用户认证和授权
 * Created by shuzheng on 2017/1/20.
 */
public class DemoShiroRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoShiroRealm.class);

    @Autowired
    private IDemoAPIService demoApiService;

    /**
     * 授权：验证权限时调用
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        DemoUser user = demoApiService.getDemoUserByUsername(username);
        List<DemoRole> roleList = demoApiService.getDemoRoleByUserId(user.getId());
        Set<String> roleSet = new HashSet();
        Set<String> permissionSet = new HashSet();
        for (DemoRole role : roleList){
            if(StringUtils.isNotBlank(role.getRoleName())){
                roleSet.add(role.getRoleName());
                List<DemoPermission> permissionList = demoApiService.getDemoPermissionByRoleId(role.getId());
                for (DemoPermission permission : permissionList) {
                    permissionSet.add(permission.getPermissionValue());
                }
            }
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissionSet);
        simpleAuthorizationInfo.setRoles(roleSet);
        return simpleAuthorizationInfo;
    }

    /**
     * 认证：登录时调用
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        // 查询用户信息
        DemoUser upmsUser = demoApiService.getDemoUserByUsername(username);
        if (null == upmsUser) {
            throw new UnknownAccountException();
        }
        if (!upmsUser.getPassword().equals(password)) {
            throw new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo(username, password, getName());
    }

}
