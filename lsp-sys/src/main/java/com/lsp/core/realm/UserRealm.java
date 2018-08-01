package com.lsp.core.realm;

import com.lsp.core.common.ShiroUtils;
import com.lsp.service.MenuService;
import com.lsp.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by songbo on 2018/8/1.
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleService roleService;
    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Long userId = ShiroUtils.getUserId();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 角色加入AuthorizationInfo认证对象
        info.setRoles(roleService.selectRoleByUserId(userId));
        // 权限加入AuthorizationInfo认证对象
        info.setStringPermissions(menuService.selectPermsByUserId(userId));
        return info;
    }

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        return null;
    }
}
