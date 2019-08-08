package com.rqy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA
 *
 * @auther XXX
 * @date 2019/8/8
 * @time 17:05
 */
@Controller
public class IndexController {
    /*访问home.jsp*/
    @RequestMapping(value = {"/","/index"})
    public String home(){

        return "home";
    }
}
