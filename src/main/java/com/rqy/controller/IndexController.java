package com.rqy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 申涛涛
 * @date 2019/8/8 16:01
 */
@Controller
public class IndexController {

    @RequestMapping(value = {"/","/index"})
    public String showlogin() {

        return "home";
    }
}
