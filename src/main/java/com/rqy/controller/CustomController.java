package com.rqy.controller;

import com.rqy.domain.Custom;
import com.rqy.domain.CustomExample;
import com.rqy.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 任清阳
 * @Email 1277409109@qq.com
 * @date 2019/8/8 18:03
 */
@Controller
@RequestMapping("custom")
public class CustomController {

    @Autowired
    CustomService customService;

    @RequestMapping("find")
    public String find(){
        return  "custom_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public List<Custom> list(CustomExample customExample){
        List<Custom> customs = customService.selectByExample(customExample);
        return  customs;
    }
    //修改前的判断
    @RequestMapping("edit_judge")
    @ResponseBody
    public Map edit_judge(){
        Map<String,Object> map=new HashMap<>();
        return  map ;
    }
    //修改操作
    @RequestMapping("update_note")
    @ResponseBody
    public Map update_note(Custom custom){
        int i = customService.updateByPrimaryKeySelective(custom);
        Map<String,Object> map=new HashMap<>();
        if (i==1){
            map.put("status","200");
        }else {
            map.put("status","302");
        }
        return map ;
    }
}
