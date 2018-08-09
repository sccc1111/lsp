package com.lsp.controller;

import com.lsp.core.common.ShiroUtils;
import com.lsp.entity.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by songbo on 2018/8/7.
 */
@Controller
public class IndexController {

    @GetMapping("/index")
    public String index(ModelMap mmap){
        //取得用户信息
        SysUser user = ShiroUtils.getUser();
        // 取身份信息
        return "index";
    }
}
