package com.rqy.controller.technology;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rqy.domain.Process;
import com.rqy.domain.ProcessExample;
import com.rqy.domain.Technology;
import com.rqy.service.technology.ProcessService;
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
 * @time 21:16
 */
@Controller
@RequestMapping("process")
public class ProcessController {
    @Autowired
    ProcessService processService;

    //通过id查询process对象
    @RequestMapping("get/{id}")
    @ResponseBody
    public Process get(@PathVariable String id){
        Process process = processService.selectByPrimaryKey(id);
        return process;
    }

    //填充下拉表get_data
    @RequestMapping("get_data")
    @ResponseBody
    public List<Process> get_data(){
        List<Process> processes = processService.selectByExample(new ProcessExample());
        return processes;
    }

    @RequestMapping("find")
    public String processFind() {
        return "process_list";
    }

    /*模糊查询*/
    @RequestMapping("search_process_by_processId")
    @ResponseBody
    public PageBean<Process> search_process_by_processId(
            @RequestParam(value = "searchValue")String id,@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows
    ){
        //模糊查询
        PageHelper.startPage(page,rows);
        List<Process> processes = processService.selectByIdLike(id);
        PageInfo<Process> pageInfo = new PageInfo<>(processes);
        long total = pageInfo.getTotal();
        PageBean pageResult = new PageBean();
        pageResult.setTotal(total);
        pageResult.setRows(processes);
        return pageResult;
    }
    /*模糊查询*/
    @RequestMapping("search_process_by_technologyPlanId")
    @ResponseBody
    public PageBean<Technology> search_process_by_technologyPlanId(
            @RequestParam(value = "searchValue")String pid, @RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows
    ){
        //模糊查询
        PageHelper.startPage(page,rows);
        List<Process> processes = processService.selectByTechnologyPlanIdLike(pid);
        PageInfo<Process> pageInfo = new PageInfo<>(processes);
        long total = pageInfo.getTotal();
        PageBean pageResult = new PageBean();
        pageResult.setTotal(total);
        pageResult.setRows(processes);
        return pageResult;
    }


    @RequestMapping("list")
    @ResponseBody
    public List<Process> processFindList() {
        ProcessExample processExample = new ProcessExample();
        return processService.selectByExample(processExample);
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
        return "process_add";
    }

    /*接受insert的数据，执行添加操作*/
    @RequestMapping("insert")
    @ResponseBody
    public Map insert(Process process){
        int i = processService.insertSelective(process);
        Map<String,String> map = new HashMap<>();
        if (i == 1){
            map.put("status","200");
            map.put("msg","ok");
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
        return "process_edit";
    }
    //修改操作
    @RequestMapping("update_all")
    @ResponseBody
    public Map update_note(Process process){
        int i = processService.updateByPrimaryKeySelective(process);
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
    public Map delete_batch(String[] ids){
        int i = processService.deleteByPrimaryKey(ids);
        Map<String,Object> map=new HashMap<>();
        if (i != 0){
            map.put("status","200");
        }else {
            map.put("status","302");
        }
        return map;
    }
}
