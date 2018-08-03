package com.lsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by songbo on 2018/8/3.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }
}
