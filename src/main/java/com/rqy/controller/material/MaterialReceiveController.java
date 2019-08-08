package com.rqy.controller.material;

import com.rqy.domain.MaterialReceive;
import com.rqy.domain.MaterialReceiveExample;
import com.rqy.service.material.MaterialReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("materialReceive")
public class MaterialReceiveController {
    @Autowired
    MaterialReceiveService materialReceiveService;

    @RequestMapping("find")
    public String find(){
        return "materialReceive_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public List<MaterialReceive> list(){
        MaterialReceiveExample example = new MaterialReceiveExample();
        List<MaterialReceive> materialReceives = materialReceiveService.selectByExample(example);
        return materialReceives;
    }
}
