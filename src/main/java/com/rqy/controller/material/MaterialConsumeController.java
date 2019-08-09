package com.rqy.controller.material;

import com.rqy.domain.MaterialConsume;
import com.rqy.domain.MaterialConsumeExample;
import com.rqy.service.material.MaterialConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
//@RequestMapping("materialConsume")
public class MaterialConsumeController {
    @Autowired
    MaterialConsumeService materialConsumeService;

    @RequestMapping("materialConsume/find")
    public String find(){
        return "materialConsume_list";
    }

    @RequestMapping("materialConsume/list")
    @ResponseBody
    public List<MaterialConsume> list(){
        MaterialConsumeExample example = new MaterialConsumeExample();
        List<MaterialConsume> materialConsumes = materialConsumeService.selectByExample(example);
        return materialConsumes;
    }
}
