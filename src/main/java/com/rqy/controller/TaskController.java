package com.rqy.controller;

import com.github.pagehelper.PageInfo;
import com.rqy.domain.Task;
import com.rqy.domain.TaskExample;
import com.rqy.service.TaskService;
import com.rqy.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @author 任清阳
 * @Email 1277409109@qq.com
 * @date 2019/8/10 18:03
 */
@Controller
@RequestMapping("task")
public class TaskController {
    @Autowired
    TaskService taskService;
    @RequestMapping("get_data")
    @ResponseBody
    public List<Task> get_data(){
        List<Task> tasks = taskService.selectByExample( new TaskExample());
        return  tasks;
    }
    @RequestMapping("find")
    public String find(){
        return  "task_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public PageBean<Task> list(int page, int rows){
        List<Task> tasks = taskService.findAllTask( page,rows);
        //查询到的数据给到PageInfo  pagehelper的封装的对象，只需要把结果集给到该对象，
        // 就可以通过该对象get方法拿到总页数，总记录数，
        PageInfo<Task> pageInfo=new PageInfo<>(tasks);
        //在自定义一个分页对象，就可以传入页面需要的list集合，和total，同时json形式返回
        PageBean<Task> pageBean=new PageBean<>(tasks,pageInfo.getTotal());

        return  pageBean;
    }
    //修改前的判断
    @RequestMapping("edit_judge")
    @ResponseBody
    public Map edit_judge(){
        Map<String,Object> map=new HashMap<>();
        return  map ;
    }
    //修改note操作
    @RequestMapping("update_note")
    @ResponseBody
    public Map update_note(Task task){
        int i = taskService.updateByPrimaryKeySelective(task);
        Map<String,Object> map=new HashMap<>();
        if (i==1){
            map.put("status","200");
        }else {
            map.put("status","302");
        }
        return  map ;
    }
    //编辑跳转页面操作
    @RequestMapping("edit")
    public String edit(){
        return   "task_edit";
    }
    //修改全部信息操作
    @RequestMapping("update_all")
    @ResponseBody
    public Map update_all(Task task){
        int i = taskService.updateByPrimaryKey(task);
        Map<String,Object> map=new HashMap<>();
        if (i==1){
            map.put("status","200");
        }else {
            map.put("status","302");
        }
        return  map ;
    }
    //添加前的判断
    @RequestMapping("add_judge")
    @ResponseBody
    public Map add_judge(){
        Map<String,Object> map=new HashMap<>();
        return  map ;
    }
    //添加页面操作
    @RequestMapping("add")
    public String add(){
        return   "task_add";
    }
    //插入信息操作
    @RequestMapping("insert")
    @ResponseBody
    public Map insert(Task task){
        int i = taskService.insert(task);
        Map<String,Object> map=new HashMap<>();
        if (i==1){
            map.put("status","200");
        }else {
            map.put("status","302");
        }
        return  map ;
    }
    //删除前的判断
    @RequestMapping("delete_judge")
    @ResponseBody
    public Map delete_judge(){
        Map<String,Object> map=new HashMap<>();
        return  map ;
    }
    //删除通过customid,拿到前端的ids数组
    @RequestMapping("delete_batch")
    @ResponseBody
    public Map delete_batch(String ids){
        TaskExample taskExample=new TaskExample();
        //将ids字符串转换为字符数组
        String[] split = ids.split(",");
        //把ids数组封装andCustomIdIn，需要的list参数
        List<String> list=new ArrayList<>(Arrays.asList(split));
        //封装条件
        taskExample.createCriteria().andTaskIdIn(list);

        int i = taskService.deleteByExample(taskExample);
        Map<String,Object> map=new HashMap<>();
        if (i!=0){
            map.put("status","200");
        }else {
            map.put("status","302");
        }
        return  map ;
    }
    //通过id查询Work
    @RequestMapping("get/{id}")
    @ResponseBody
    public Task get(@PathVariable String id){
        Task task = taskService.selectByPrimaryKey(id);
        return task;
    }
    //模糊查询search_manufacture_by_taskWorkId，taskId,taskManufactureSn
    @RequestMapping("search_task_by_taskManufactureSn")
    @ResponseBody
    public PageBean<Task> search_task_by_taskManufactureSn(int page,int rows,String searchValue){
        TaskExample taskExample = new TaskExample();
        taskExample.createCriteria().andManufactureSnLike("%"+searchValue+"%");
        List<Task> tasks = taskService.findAllTaskByIdOrWorkIdOrManufactureSn( page,rows,taskExample);
        //查询到的数据给到PageInfo  pagehelper的封装的对象，只需要把结果集给到该对象，
        // 就可以通过该对象get方法拿到总页数，总记录数，
        PageInfo<Task> pageInfo=new PageInfo<>(tasks);
        //在自定义一个分页对象，就可以传入页面需要的list集合，和total，同时json形式返回
        PageBean<Task> pageBean=new PageBean<>(tasks,pageInfo.getTotal());
        return  pageBean;
    }
    @RequestMapping("search_task_by_taskId")
    @ResponseBody
    public PageBean<Task> search_task_by_taskId(int page,int rows,String searchValue){
        TaskExample taskExample = new TaskExample();
        taskExample.createCriteria().andTaskIdLike("%"+searchValue+"%");
        List<Task> tasks = taskService.findAllTaskByIdOrWorkIdOrManufactureSn( page,rows,taskExample);
        //查询到的数据给到PageInfo  pagehelper的封装的对象，只需要把结果集给到该对象，
        // 就可以通过该对象get方法拿到总页数，总记录数，
        PageInfo<Task> pageInfo=new PageInfo<>(tasks);
        //在自定义一个分页对象，就可以传入页面需要的list集合，和total，同时json形式返回
        PageBean<Task> pageBean=new PageBean<>(tasks,pageInfo.getTotal());
        return  pageBean;
    }
    @RequestMapping("search_task_by_taskWorkId")
    @ResponseBody
    public PageBean<Task> search_task_by_taskWorkId(int page,int rows,String searchValue){
        TaskExample taskExample = new TaskExample();
        taskExample.createCriteria().andWorkIdLike("%"+searchValue+"%");
        List<Task> tasks = taskService.findAllTaskByIdOrWorkIdOrManufactureSn( page,rows,taskExample);
        //查询到的数据给到PageInfo  pagehelper的封装的对象，只需要把结果集给到该对象，
        // 就可以通过该对象get方法拿到总页数，总记录数，
        PageInfo<Task> pageInfo=new PageInfo<>(tasks);
        //在自定义一个分页对象，就可以传入页面需要的list集合，和total，同时json形式返回
        PageBean<Task> pageBean=new PageBean<>(tasks,pageInfo.getTotal());
        return  pageBean;
    }
}
