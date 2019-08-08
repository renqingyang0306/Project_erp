package com.rqy.controller;

import com.rqy.domain.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 任清阳
 * @Email 1277409109@qq.com
 * @date 2019/8/8 15:44
 */
@Controller
public class IndexController {

    @RequestMapping(value = {"/","index"})
    public String home(){
        return "home";
    }
    @RequestMapping("*")
    public String error(){
        return "404";
    }

}
