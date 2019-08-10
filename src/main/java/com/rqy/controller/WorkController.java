package com.rqy.controller;

import com.github.pagehelper.PageInfo;
import com.rqy.domain.Work;
import com.rqy.domain.WorkExample;
import com.rqy.service.WorkServcie;
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
 * @date 2019/8/10 12:16
 */
@Controller
@RequestMapping("work")
public class WorkController {
    @Autowired
    WorkServcie workServcie;

    //客户信息，用于查询查询全部数据填充下拉列表的
    @RequestMapping("get_data")
    @ResponseBody
    public List<Work> get_data(){
        List<Work> works = workServcie.selectByExample( new WorkExample());
        return  works;
    }
    @RequestMapping("find")
    public String find(){
        return  "work_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public PageBean<Work> list(int page, int rows){
        List<Work> works = workServcie.findAllWork( page,rows);
        //查询到的数据给到PageInfo  pagehelper的封装的对象，只需要把结果集给到该对象，
        // 就可以通过该对象get方法拿到总页数，总记录数，
        PageInfo<Work> pageInfo=new PageInfo<>(works);
        //在自定义一个分页对象，就可以传入页面需要的list集合，和total，同时json形式返回
        PageBean<Work> pageBean=new PageBean<>(works,pageInfo.getTotal());

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
    public Map update_note(Work work){
        int i = workServcie.updateByPrimaryKeySelective(work);
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
        return   "work_edit";
    }
    //修改全部信息操作
    @RequestMapping("update_all")
    @ResponseBody
    public Map update_all(Work work){
        int i = workServcie.updateByPrimaryKey(work);
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
        return   "work_add";
    }
    //插入信息操作
    @RequestMapping("insert")
    @ResponseBody
    public Map insert(Work work){
        int i = workServcie.insert(work);
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
        WorkExample workExample=new WorkExample();
        //将ids字符串转换为字符数组
        String[] split = ids.split(",");
        //把ids数组封装andCustomIdIn，需要的list参数
        List<String> list=new ArrayList<>(Arrays.asList(split));
        //封装条件
        workExample.createCriteria().andProductIdIn(list);

        int i = workServcie.deleteByExample(workExample);
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
    public Work get(@PathVariable String id){
        Work work = workServcie.selectByPrimaryKey(id);
        return work;
    }
    //模糊查询search_work_by_workId，workProduct,workDevice,workProcess
    @RequestMapping("search_work_by_workId")
    @ResponseBody
    public PageBean<Work> search_work_by_workId(int page,int rows,String searchValue){
        WorkExample workExample = new WorkExample();
        workExample.createCriteria().andWorkIdLike("%"+searchValue+"%");
        List<Work> works = workServcie.findAllWorkByIdOrProcessId( page,rows,workExample);
        //查询到的数据给到PageInfo  pagehelper的封装的对象，只需要把结果集给到该对象，
        // 就可以通过该对象get方法拿到总页数，总记录数，
        PageInfo<Work> pageInfo=new PageInfo<>(works);
        //在自定义一个分页对象，就可以传入页面需要的list集合，和total，同时json形式返回
        PageBean<Work> pageBean=new PageBean<>(works,pageInfo.getTotal());

        return  pageBean;
    }
    @RequestMapping("search_work_by_workProduct")
    @ResponseBody
    public PageBean<Work> search_work_by_workProduct(int page,int rows,String searchValue){
        List<Work> works = workServcie.findAllWorkByProductName( page,rows,"%"+searchValue+"%");
        //查询到的数据给到PageInfo  pagehelper的封装的对象，只需要把结果集给到该对象，
        // 就可以通过该对象get方法拿到总页数，总记录数，
        PageInfo<Work> pageInfo=new PageInfo<>(works);
        //在自定义一个分页对象，就可以传入页面需要的list集合，和total，同时json形式返回
        PageBean<Work> pageBean=new PageBean<>(works,pageInfo.getTotal());

        return  pageBean;
    }
    @RequestMapping("search_work_by_workDevice")
    @ResponseBody
    public PageBean<Work> search_work_by_workDevice(int page,int rows,String searchValue){
        List<Work> works = workServcie.findAllWorkByDeviceName( page,rows,"%"+searchValue+"%");
        //查询到的数据给到PageInfo  pagehelper的封装的对象，只需要把结果集给到该对象，
        // 就可以通过该对象get方法拿到总页数，总记录数，
        PageInfo<Work> pageInfo=new PageInfo<>(works);
        //在自定义一个分页对象，就可以传入页面需要的list集合，和total，同时json形式返回
        PageBean<Work> pageBean=new PageBean<>(works,pageInfo.getTotal());

        return  pageBean;
    }
    @RequestMapping("search_work_by_workProcess")
    @ResponseBody
    public PageBean<Work> search_work_by_workProcess(int page,int rows,String searchValue){
        WorkExample workExample = new WorkExample();
        workExample.createCriteria().andProcessIdLike("%"+searchValue+"%");
        List<Work> works = workServcie.findAllWorkByIdOrProcessId( page,rows,workExample);
        //查询到的数据给到PageInfo  pagehelper的封装的对象，只需要把结果集给到该对象，
        // 就可以通过该对象get方法拿到总页数，总记录数，
        PageInfo<Work> pageInfo=new PageInfo<>(works);
        //在自定义一个分页对象，就可以传入页面需要的list集合，和total，同时json形式返回
        PageBean<Work> pageBean=new PageBean<>(works,pageInfo.getTotal());

        return  pageBean;
    }
}
