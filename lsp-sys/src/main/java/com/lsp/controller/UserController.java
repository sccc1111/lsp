package com.lsp.controller;

import com.lsp.core.common.PasswordUtils;
import com.lsp.entity.SysUser;
import com.lsp.result.PageEntity;
import com.lsp.result.R;
import com.lsp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/user/detail")
    public String index(String type,String userId,ModelMap map){
        if("1".equals(type)){
            //新规的场合
        }else {
            //其他场合
        }
        map.put("type",type);
        return "user/userDetail";
    }

    @PostMapping("/user/detail/add")
    @ResponseBody
    public R index(@RequestBody SysUser user, ModelMap map){
        user.setSalt(PasswordUtils.getSalt());
        user.setPassword(PasswordUtils.getPassword("123456",user.getSalt()));
        userService.add(user);
        return R.ok("保存成功");
    }

}
