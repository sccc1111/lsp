package com.lsp.core.filter;

import com.google.code.kaptcha.Constants;
import com.lsp.core.common.ShiroUtils;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by songbo on 2018/8/6.
 */
public class CaptchaValidateFilter extends AccessControlFilter {

    /**
     * 是否开启验证码
     */
    @Setter @Getter
    private boolean captchaEbabled = true;

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        // 验证码禁用不是表单提交 允许访问
        if (captchaEbabled == false || !"post".equals(httpServletRequest.getMethod().toLowerCase()))
        {
            return true;
        }
        return validateResponse(httpServletRequest, httpServletRequest.getParameter("code"));
    }

    public boolean validateResponse(HttpServletRequest request, String validateCode)
    {
        Object obj = ShiroUtils.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        String code = String.valueOf(obj != null ? obj : "");
        if (StringUtils.isEmpty(validateCode) || !validateCode.equalsIgnoreCase(code))
        {
            return false;
        }
        return true;
    }
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        servletRequest.setAttribute("Constants.CAPTCHA_KEY", "Constants.CAPTCHA_ERROR");
        return true;
    }
}
