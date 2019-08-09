package com.rqy.controller.technology;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rqy.domain.*;
import com.rqy.service.technology.TechnologyRequirementService;
import com.rqy.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 *
 * @auther XXX
 * @date 2019/8/8
 * @time 15:59
 */
@Controller
@RequestMapping("technologyRequirement")
public class TechnologyRequirementController {

    @Autowired
    TechnologyRequirementService technologyRequirementService;

    @RequestMapping("find")
    public String technologyRequirementFind() {
        return "technologyRequirement_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public PageBean<TechnologyRequirement> technologyRequirementsFindList(@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows) {
        PageHelper.startPage(page, rows);
        List<TechnologyRequirement> technologyRequirements = technologyRequirementService.selectLeftJoin();
        PageInfo<TechnologyRequirement> pageInfo = new PageInfo<>(technologyRequirements);
        long total = pageInfo.getTotal();
        PageBean pageResult = new PageBean();
        pageResult.setTotal(total);
        pageResult.setRows(technologyRequirements);
        return pageResult;
        /*
        */
    }

    /*add界面，异步请求technology/add_judge,返回值为json*/
    @RequestMapping("add_judge")
    @ResponseBody
    public String add_judge(){
        return "";
    }
    /*加载到technology_add.jsp页面*/
    @RequestMapping("add")
    public String add(){
        return "technologyRequirement_add";
    }

    /*接受insert的数据，执行添加操作*/
    @RequestMapping("insert")
    public Map insert(TechnologyRequirement technologyRequirement){
        int i = technologyRequirementService.insertSelective(technologyRequirement);
        Map<String,String> map = new HashMap<>();
        if (i == 1){
            map.put("status","200");
        }else {
            map.put("status","302");
        }
        return map;
    }

    //修改前的判断
    @RequestMapping("edit_judge")
    @ResponseBody
    public Map edit_judge(){
        Map<String,Object> map=new HashMap<>();
        return  map;
    }
    /*加载到technology_add.jsp页面*/
    @RequestMapping("edit")
    public String edit(){
        return "technologyRequirement_edit";
    }
    //修改操作
    @RequestMapping("update_all")
    @ResponseBody
    public Map update_note(TechnologyRequirement technologyRequirement){
        int i = technologyRequirementService.updateByPrimaryKeySelective(technologyRequirement);
        Map<String,Object> map=new HashMap<>();
        if (i==1){
            map.put("status","200");
        }else {
            map.put("status","302");
        }
        return map;
    }
    /*删除*/
    @RequestMapping("delete_judge")
    @ResponseBody
    public Map delete_judge(){
        Map<String,Object> map=new HashMap<>();
        return  map;
    }
    @RequestMapping("delete_batch")
    @ResponseBody
    public Map delete_batch(String ids){
        int i = technologyRequirementService.deleteByPrimaryKey(ids);
        Map<String,Object> map=new HashMap<>();
        if (i == 1){
            map.put("status","200");
        }else {
            map.put("status","302");
        }
        return map;
    }
}
