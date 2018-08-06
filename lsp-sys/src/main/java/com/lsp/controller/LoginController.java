package com.lsp.controller;

import com.lsp.core.common.Constants;
import com.lsp.core.common.ShiroUtils;
import com.lsp.result.R;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by songbo on 2018/8/3.
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response)
    {
        return "login";
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public R login(ServletRequest request, ServletResponse response, Model model, String username, String password, Boolean rememberMe){
        String codeMsg = (String) request.getAttribute(Constants.CAPTCHA_KEY);
        if(Constants.CAPTCHA_ERROR.equals(codeMsg)){
            return R.error("验证码错误");
        }
        UsernamePasswordToken token = new UsernamePasswordToken(username,
                password);
        Subject subject = ShiroUtils.getSubjct();
        String msg = null;
        try {
            subject.login(token);
            if (subject.isAuthenticated()) {
                return R.ok("验证成功");
            }
        } catch (UnknownAccountException e) {
            msg = "用户名/密码错误";
        } catch (IncorrectCredentialsException e) {
            msg = "用户名/密码错误";
        }
        return R.error(msg);
    }
}
