package com.rqy.controller.material;

import com.rqy.domain.Material;
import com.rqy.domain.MaterialExample;
import com.rqy.service.material.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("material")
public class MaterialController {
    @Autowired
    MaterialService materialService;

    @RequestMapping("find")
    public String find(){
        return "material_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public List<Material> list(){
        MaterialExample example = new MaterialExample();
        List<Material> materials = materialService.selectByExample(example);
        return materials;
    }
    @RequestMapping("get/{id}")
    @ResponseBody
    public Material list(@PathVariable String id){
        Material material = materialService.selectByPrimaryKey(id);
        return material;
    }
//    @RequestMapping("edit_judge")
//    public Material list(@PathVariable String id){
//        Material material = materialService.selectByPrimaryKey(id);
//        return material;
//    }
}
