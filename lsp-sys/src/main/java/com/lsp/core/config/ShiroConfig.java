package com.lsp.core.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.lsp.core.filter.CaptchaValidateFilter;
import com.lsp.core.realm.UserRealm;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by songbo on 2018/8/1.
 */
@Configuration
public class ShiroConfig {

    // 验证码开关
    @Value("${shiro.user.captchaEbabled}")
    private boolean captchaEbabled;

    /**
     * 身份认证realm;
     *
     * @return
     */
    @Bean(name="myShiroRealm")
    public UserRealm myShiroRealm(@Qualifier("credentialsMatcherConfig")HashedCredentialsMatcher credentialsMatcher) {
        UserRealm myShiroRealm = new UserRealm();
        myShiroRealm.setCredentialsMatcher(credentialsMatcher);
        return myShiroRealm;
    }

    @Bean
    public SecurityManager securityManager(@Qualifier("myShiroRealm") UserRealm myShiroRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(myShiroRealm);
        //注入缓存管理器;
        securityManager.setCacheManager(ehCacheManager());
        return securityManager;
    }

    /**
     * 缓存管理器 使用Ehcache实现
     */
    @Bean(name="ehCacheManager")
    public EhCacheManager ehCacheManager()
    {
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:ehcache/ehcache-shiro.xml");
        return cacheManager;
    }
    /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，以为在
     * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
     *
     * Filter Chain定义说明 1、一个URL可以配置多个Filter，使用逗号分隔 2、当设置多个过滤器时，全部验证通过，才视为通过
     * 3、部分过滤器可指定参数，如perms，roles
     *
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 身份认证失败，则跳转到登录页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        Map<String, Filter> filters = new LinkedHashMap<>();
        filters.put("captchaValidate", captchaValidateFilter());
        shiroFilterFactoryBean.setFilters(filters);
        // 拦截器.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/login", "anon,captchaValidate");
        filterChainDefinitionMap.put("/captcha/captchaImage", "anon");
        // 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
        // <!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }
    /**
     * 自定义验证码过滤器
     */
    @Bean
    public CaptchaValidateFilter captchaValidateFilter()
    {
        CaptchaValidateFilter captchaValidateFilter = new CaptchaValidateFilter();
        captchaValidateFilter.setCaptchaEbabled(captchaEbabled);
        return captchaValidateFilter;
    }

    @Bean(name="credentialsMatcherConfig")
    public HashedCredentialsMatcher getCredentialsMatcherConfig(@Qualifier("ehCacheManager") EhCacheManager ehCacheManager){
        return new CredentialsMatcherConfig(ehCacheManager);
    }
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
}
