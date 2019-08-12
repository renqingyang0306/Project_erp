package com.rqy.controller;

import com.github.pagehelper.PageInfo;
import com.rqy.domain.Custom;
import com.rqy.domain.CustomExample;
import com.rqy.service.CustomService;
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
 * @date 2019/8/8 18:03
 */
@Controller
@RequestMapping("custom")
public class CustomController {

    @Autowired
    CustomService customService;

    @RequestMapping("find")
    public String find(){
        return  "custom_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public PageBean<Custom> list(int page,int rows){
        List<Custom> customs = customService.findAllCustom( page,rows);
        //查询到的数据给到PageInfo  pagehelper的封装的对象，只需要把结果集给到该对象，
        // 就可以通过该对象get方法拿到总页数，总记录数，
        PageInfo<Custom> pageInfo=new PageInfo<>(customs);
        //在自定义一个分页对象，就可以传入页面需要的list集合，和total，同时json形式返回
        PageBean<Custom> pageBean=new PageBean<>(customs,pageInfo.getTotal());

        return  pageBean;
    }
    //通过id查询Custom
    @RequestMapping("get/{id}")
    @ResponseBody
    public Custom get(@PathVariable String id){
        Custom custom = customService.selectByPrimaryKey(id);
        return custom;
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
    public Map update_note(Custom custom){
        int i = customService.updateByPrimaryKeySelective(custom);
        Map<String,Object> map=new HashMap<>();
        if (i==1){
            map.put("status","200");
        }else {
            map.put("status","302");
        }
        return map ;
    }
    //编辑跳转页面操作
    @RequestMapping("edit")
    public String edit(){
        return   "custom_edit";
    }
    //修改全部信息操作
    @RequestMapping("update_all")
    @ResponseBody
    public Map update_all(Custom custom){
        int i = customService.updateByPrimaryKey(custom);
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
        return   "custom_add";
    }
    //插入信息操作
    @RequestMapping("insert")
    @ResponseBody
    public Map insert(Custom custom){
        int i = customService.insert(custom);
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
        CustomExample customExample=new CustomExample();
        //将ids字符串转换为字符数组
        String[] split = ids.split(",");
        //把ids数组封装andCustomIdIn，需要的list参数
        List<String> list=new ArrayList<>(Arrays.asList(split));
        //封装条件
        customExample.createCriteria().andCustomIdIn(list);

        int i = customService.deleteByExample(customExample);
        Map<String,Object> map=new HashMap<>();
        if (i!=0){
            map.put("status","200");
        }else {
            map.put("status","302");
        }
        return  map ;
    }
    //模糊查询search_custom_by_customId，customName
    @RequestMapping("search_custom_by_customId")
    @ResponseBody
    public PageBean<Custom> search_custom_by_customId(int page,int rows,String searchValue){
        CustomExample customExample = new CustomExample();
        customExample.createCriteria().andCustomIdLike("%"+searchValue+"%");
        List<Custom> customs = customService.findAllCustomByIdOrName( page,rows,customExample);
        //查询到的数据给到PageInfo  pagehelper的封装的对象，只需要把结果集给到该对象，
        // 就可以通过该对象get方法拿到总页数，总记录数，
        PageInfo<Custom> pageInfo=new PageInfo<>(customs);
        //在自定义一个分页对象，就可以传入页面需要的list集合，和total，同时json形式返回
        PageBean<Custom> pageBean=new PageBean<>(customs,pageInfo.getTotal());

        return  pageBean;
    }
    @RequestMapping("search_custom_by_customName")
    @ResponseBody
    public PageBean<Custom> search_custom_by_customName(int page,int rows,String searchValue){
        CustomExample customExample = new CustomExample();
        customExample.createCriteria().andCustomNameLike("%"+searchValue+"%");
        List<Custom> customs = customService.findAllCustomByIdOrName( page,rows,customExample);
        //查询到的数据给到PageInfo  pagehelper的封装的对象，只需要把结果集给到该对象，
        // 就可以通过该对象get方法拿到总页数，总记录数，
        PageInfo<Custom> pageInfo=new PageInfo<>(customs);
        //在自定义一个分页对象，就可以传入页面需要的list集合，和total，同时json形式返回
        PageBean<Custom> pageBean=new PageBean<>(customs,pageInfo.getTotal());

        return  pageBean;
    }
    //客户信息，用于查询查询全部数据填充下拉列表的
    @RequestMapping("get_data")
    @ResponseBody
    public List<Custom> get_data(){
        List<Custom> customs = customService.selectByExample( new CustomExample());
        return  customs;
    }
}
