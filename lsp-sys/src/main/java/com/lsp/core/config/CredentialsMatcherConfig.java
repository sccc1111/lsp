package com.lsp.core.config;

import com.lsp.core.common.PasswordUtils;
import com.lsp.entity.SysUser;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.credential.PasswordMatcher;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by songbo on 2018/8/7.
 */
public class CredentialsMatcherConfig extends HashedCredentialsMatcher {

    private Cache<String, AtomicInteger> passwordRetryCache;

    public CredentialsMatcherConfig(CacheManager cacheManager) {
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
        this.setHashAlgorithmName(PasswordUtils.ALGORITHM_NAME);
        this.setHashIterations(PasswordUtils.HASH_ITERATIONS);
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken atoken = (UsernamePasswordToken) token;
        String username = atoken.getUsername();
        AtomicInteger retryCount = passwordRetryCache.get(username);
        if (retryCount == null) {
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(username, retryCount);
        }
        if (retryCount.incrementAndGet() > 5) {
            // if retry count > 5 throw
            throw new ExcessiveAttemptsException("密码登录错误次数太多，请十分钟已后尝试登录");
        }
        boolean matches = super.doCredentialsMatch(token, info);
        if (matches) {
            passwordRetryCache.remove(username);
        }
        return matches;
    }
}
