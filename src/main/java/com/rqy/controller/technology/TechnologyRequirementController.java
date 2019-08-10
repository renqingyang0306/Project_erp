package com.rqy.controller.technology;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rqy.domain.*;
import com.rqy.service.technology.TechnologyRequirementService;
<<<<<<< HEAD
=======
import com.rqy.service.technology.TechnologyService;
>>>>>>> cdfeb3f536dd5ea1a6c36da8d2550c3972d3bbba
import com.rqy.utils.PageBean;
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
    @Autowired
    TechnologyService technologyService;

    @RequestMapping("find")
    public String technologyRequirementFind() {
        return "technologyRequirement_list";
    }

    /*模糊查询*/
    @RequestMapping("search_technologyRequirement_by_technologyRequirementId")
    @ResponseBody
    public PageBean<TechnologyRequirement> search_technologyRequirement_by_technologyRequirementId(
            @RequestParam(value = "searchValue")String id,@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows
    ){
        //模糊查询
        PageHelper.startPage(page,rows);
        List<TechnologyRequirement> technologyRequirements = technologyRequirementService.selectByIdLike(id);
        PageInfo<TechnologyRequirement> pageInfo = new PageInfo<>(technologyRequirements);
        long total = pageInfo.getTotal();
        PageBean pageResult = new PageBean();
        pageResult.setTotal(total);
        pageResult.setRows(technologyRequirements);
        return pageResult;
    }
    /*模糊查询*/
    @RequestMapping("search_technologyRequirement_by_technologyName")
    @ResponseBody
    public PageBean<TechnologyRequirement> search_technologyRequirement_by_technologyName(
            @RequestParam(value = "searchValue")String name,@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows
    ){
        //模糊查询
        PageHelper.startPage(page,rows);
        List<TechnologyRequirement> technologyRequirements = technologyRequirementService.selectByNameLike(name);
        PageInfo<TechnologyRequirement> pageInfo = new PageInfo<>(technologyRequirements);
        long total = pageInfo.getTotal();
        PageBean pageResult = new PageBean();
        pageResult.setTotal(total);
        pageResult.setRows(technologyRequirements);
        return pageResult;
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
    @ResponseBody
    public Map insert(TechnologyRequirement technologyRequirement){
        int i = technologyRequirementService.insertSelective(technologyRequirement);
        Map<String,String> map = new HashMap<>();
        if (i == 1){
            map.put("status","200");
            map.put("msg","ok");
        }else {
            map.put("status","302");
        }
        return map;
    }

    //insert的下拉框
    @RequestMapping("get_data")
    @ResponseBody
    public List<Technology> get_data(){
        TechnologyExample technologyExample = new TechnologyExample();
        List<Technology> technologies = technologyService.selectByExample(technologyExample);
        return technologies;
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
    public Map delete_batch(String[] ids){
        int i = technologyRequirementService.deleteByPrimaryKey(ids);
        Map<String,Object> map=new HashMap<>();
        if (i != 0){
            map.put("status","200");
        }else {
            map.put("status","302");
        }
        return map;
    }
}
