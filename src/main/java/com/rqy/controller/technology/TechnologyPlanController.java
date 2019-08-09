package com.rqy.controller.technology;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rqy.domain.Technology;
import com.rqy.domain.TechnologyPlan;
import com.rqy.domain.TechnologyPlanExample;
import com.rqy.service.technology.TechnologyPlanService;
import com.rqy.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("technologyPlan")
public class TechnologyPlanController {

    @Autowired
    TechnologyPlanService technologyPlanService;

    @RequestMapping("find")
    public String technologyPlanFind() {
        return "technologyPlan_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public PageBean<TechnologyPlan> technologyPlanFindList(@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows) {
        PageHelper.startPage(page, rows);
        List<TechnologyPlan> technologyPlans = technologyPlanService.selectLeftJoin();

        PageInfo<TechnologyPlan> pageInfo = new PageInfo<>(technologyPlans);

        long total = pageInfo.getTotal();

        PageBean pageResult = new PageBean();

        pageResult.setTotal(total);
        pageResult.setRows(technologyPlans);
        return pageResult;
        /**/
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
        return "technologyPlan_add";
    }

    /*接受insert的数据，执行添加操作*/
    @RequestMapping("insert")
    public Map insert(TechnologyPlan technologyPlan){
        int i = technologyPlanService.insertSelective(technologyPlan);
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
        return map;
    }
    /*加载到technology_add.jsp页面*/
    @RequestMapping("edit")
    public String edit(){
        return "technologyPlan_edit";
    }
    //修改操作
    @RequestMapping("update_all")
    @ResponseBody
    public Map update_note(TechnologyPlan technologyPlan){
        int i = technologyPlanService.updateByPrimaryKeySelective(technologyPlan);
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
        return map;
    }
    @RequestMapping("delete_batch")
    @ResponseBody
    public Map delete_batch(String ids){
        int i = technologyPlanService.deleteByPrimaryKey(ids);
        Map<String,Object> map=new HashMap<>();
        if (i == 1){
            map.put("status","200");
        }else {
            map.put("status","302");
        }
        return map;
    }
}
