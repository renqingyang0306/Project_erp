package com.rqy.controller.technology;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rqy.domain.Technology;
import com.rqy.domain.TechnologyExample;
import com.rqy.service.technology.TechnologyService;
import com.rqy.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
 * @time 15:57
 */
@Controller
@RequestMapping("technology")
public class TechnologyController {
    /*注入TechnologyService*/
    @Autowired
    TechnologyService technologyService;
    /*跳转到页面*/
    @RequestMapping("find")
    public String technologyFind() {

        return "technology_list";
    }

    //通过id查询process对象
    @RequestMapping("get/{id}")
    @ResponseBody
    public Technology get(@PathVariable String id){
        Technology technology  = technologyService.selectByPrimaryKey(id);
        return technology;
    }

    /*模糊查询*/
    @RequestMapping("search_technology_by_technologyId")
    @ResponseBody
    public PageBean<Technology> search_technology_by_technologyId(
            @RequestParam(value = "searchValue")String id,@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows
    ){
        //模糊查询
        PageHelper.startPage(page,rows);
        List<Technology> technologies = technologyService.selectByIdLike(id);
        PageInfo<Technology> pageInfo = new PageInfo<>(technologies);
        long total = pageInfo.getTotal();
        PageBean pageResult = new PageBean();
        pageResult.setTotal(total);
        pageResult.setRows(technologies);
        return pageResult;
    }
    /*模糊查询*/
    @RequestMapping("search_technology_by_technologyName")
    @ResponseBody
    public PageBean<Technology> search_technology_by_technologyName(
            @RequestParam(value = "searchValue")String name,@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows
    ){
        //模糊查询
        PageHelper.startPage(page,rows);
        List<Technology> technologies = technologyService.selectByNameLike(name);
        PageInfo<Technology> pageInfo = new PageInfo<>(technologies);
        long total = pageInfo.getTotal();
        PageBean pageResult = new PageBean();
        pageResult.setTotal(total);
        pageResult.setRows(technologies);
        return pageResult;
    }



    /*获得数据@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows*/
    @RequestMapping("list")
    @ResponseBody
    public PageBean<Technology> technologyFindList(@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows) {
        /*查询technology表里的数据，返回list集合数据*/
        TechnologyExample technologyExample = new TechnologyExample();
        PageHelper.startPage(page, rows);
        List<Technology> technologies = technologyService.selectByExample(technologyExample);

        PageInfo<Technology> pageInfo = new PageInfo<>(technologies);

        long total = pageInfo.getTotal();

        PageBean pageResult = new PageBean();

        pageResult.setTotal(total);
        pageResult.setRows(technologies);
        return pageResult;
    }

    /*add界面，异步请求technology/add_judge,返回值为json*/
    @RequestMapping("add_judge")
    @ResponseBody
    public String add_judge(){
        HashMap<Object, String> Map = new HashMap<>();
        return "";
    }
    /*加载到technology_add.jsp页面*/
    @RequestMapping("add")
    public String add(){
        return "technology_add";
    }

    /*接受insert的数据，执行添加操作*/
    @RequestMapping("insert")
    @ResponseBody
    public Map insert(Technology technology){
        int i = technologyService.insertSelective(technology);
        Map<String,String> map = new HashMap<>();
        if (i != 0){
            map.put("status","200");
            map.put("msg","ok");
        }else {
            map.put("status","302");
        }
        return  map;
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
        return "technology_edit";
    }
    //修改操作
    @RequestMapping("update_all")
    @ResponseBody
    public Map update_note(Technology technology){
        int i = technologyService.updateByPrimaryKeySelective(technology);
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
        int i = technologyService.deleteByPrimaryKey(ids);
        Map<String,Object> map=new HashMap<>();
        if (i != 0){
            map.put("status","200");
        }else {
            map.put("status","302");
        }
        return map;
    }
}
