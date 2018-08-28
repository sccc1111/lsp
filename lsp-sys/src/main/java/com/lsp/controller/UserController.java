package com.lsp.controller;

import com.lsp.entity.SysUser;
import com.lsp.result.PageEntity;
import com.lsp.result.R;
import com.lsp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by songbo on 2018/8/1.
 */
@Controller
@RequestMapping("/sys")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String index(ModelMap map){
        return "user/user";
    }

    @RequestMapping("/user/list")
    @ResponseBody
    public R list(SysUser user, PageEntity page){
        //分页参数设置
        startPage(page);
        //返回查询信息
        return  getDataTable(userService.selectUserList(user));
    }

}
