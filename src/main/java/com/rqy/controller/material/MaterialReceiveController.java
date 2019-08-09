package com.rqy.controller.material;

import com.github.pagehelper.PageInfo;
import com.rqy.domain.Material;
import com.rqy.domain.MaterialReceive;
import com.rqy.domain.MaterialReceiveExample;
import com.rqy.service.material.MaterialReceiveService;
import com.rqy.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("materialReceive")
public class MaterialReceiveController {
    @Autowired
    MaterialReceiveService materialReceiveService;

    @RequestMapping("find")
    public String find() {
        return "materialReceive_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public PageBean<MaterialReceive> list(int page, int rows) {
        List<MaterialReceive> allMaterial = materialReceiveService.findAllMaterial(page, rows);
        PageInfo<MaterialReceive> pageInfo = new PageInfo<>(allMaterial);
        PageBean<MaterialReceive> pageBean = new PageBean<>(allMaterial, pageInfo.getTotal());
        return pageBean;
    }

    //新增前的判断
    @RequestMapping("add_judge")
    @ResponseBody
    public Map add_judge() {
        HashMap<String, Object> map = new HashMap<>();
        return map;
    }
    //点击新增后跳转jsp页面
    @RequestMapping("add")
    public String add(){
        return "materialReceive_add";
    }
    //新增里点击提交按钮
    @RequestMapping("insert")
    @ResponseBody
    public Map insert(MaterialReceive materialReceive){
        int insert = materialReceiveService.insert(materialReceive);
        HashMap<String, Object> map = new HashMap<>();
        if(insert != 0){
            map.put("status","200");
        }
        else {
            map.put("status","302");
        }
        return map;
    }

    //删除前的判断
    @RequestMapping("delete_judge")
    @ResponseBody
    public Map delete_judge(){
        HashMap<String, Object> map = new HashMap<>();
        return map;
    }
    //可选择（一个或多个，故用deleteByExample方法）删除操作
    @RequestMapping("delete_batch")
    @ResponseBody
    public Map delete_batch(String ids){
        MaterialReceiveExample example = new MaterialReceiveExample();
        //将ids字符串转化为数组
        String[] split = ids.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(split));
        example.createCriteria().andMaterialIdIn(list);
        int i = materialReceiveService.deleteByExample(example);
        HashMap<String, Object> map = new HashMap<>();
        if(i != 0){
            map.put("status","200");
        }else {
            map.put("status","302");
        }
        return map;
    }
}
