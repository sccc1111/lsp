package com.lsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by songbo on 2018/8/1.
 */
@Controller
@RequestMapping("/sys")
public class MenuController extends BaseController {

    @GetMapping("/menu")
    public String index(ModelMap mmap){
        return "menu/menu";
    }
}
