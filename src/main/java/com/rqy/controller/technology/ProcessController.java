package com.rqy.controller.technology;

import com.rqy.domain.Process;
import com.rqy.domain.ProcessExample;
import com.rqy.domain.Technology;
import com.rqy.service.technology.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("find")
    public String processFind() {
        return "process_list";
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
    public Map insert(Process process){
        int i = processService.insertSelective(process);
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
    public Map delete_batch(String ids){
        int i = processService.deleteByPrimaryKey(ids);
        Map<String,Object> map=new HashMap<>();
        if (i == 1){
            map.put("status","200");
        }else {
            map.put("status","302");
        }
        return map;
    }
}
