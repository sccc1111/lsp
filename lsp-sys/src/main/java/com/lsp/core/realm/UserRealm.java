package com.lsp.core.realm;

import com.lsp.core.common.ShiroUtils;
import com.lsp.entity.SysUser;
import com.lsp.service.MenuService;
import com.lsp.service.RoleService;
import com.lsp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

/**
 * Created by songbo on 2018/8/1.
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;
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
        info.setStringPermissions(menuService.selectMenuByUserId(userId));
        return info;
    }

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken=(UsernamePasswordToken) token;
        SysUser user = userService.selectUserByUserName(upToken.getUsername());
        //账号不存在
        if(user == null){
            throw new UnknownAccountException("用户不存在");
        }
        else if("1".equals(user.getStatus())){
            throw new DisabledAccountException("帐号已经停用");
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(), ByteSource.Util.bytes(user.getSalt()),getName());
    }

    /**
     * 清理缓存权限
     */
    public void clearCachedAuthorizationInfo()
    {
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }

}
