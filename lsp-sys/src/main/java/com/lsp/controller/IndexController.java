package com.lsp.controller;

import com.lsp.core.common.ShiroUtils;
import com.lsp.entity.SysMenu;
import com.lsp.entity.SysUser;
import com.lsp.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by songbo on 2018/8/7.
 */
@Controller
@RequestMapping("/sys")
public class IndexController extends BaseController{

    @Autowired
    public MenuService menuServiceImpl;

    @GetMapping("/index")
    public String index(ModelMap mmap){
        //取得用户信息
        SysUser user = getUser();
        //取得菜单
        List<SysMenu> menuList = menuServiceImpl.selectMenuTree(user.getUserId());
        mmap.addAttribute("user",user);
        mmap.addAttribute("menuList",menuList);
        // 取身份信息
        return "index";
    }

    @GetMapping("/main")
    public String main(ModelMap mmap){
        return "main/main";
    }
}
