package com.rqy.controller;

import com.github.pagehelper.PageInfo;
import com.rqy.domain.Manufacture;
import com.rqy.domain.ManufactureExample;
import com.rqy.domain.WorkExample;
import com.rqy.service.ManufactureService;
import com.rqy.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.nio.cs.ext.MacArabic;

import java.util.*;

/**
 * @author 任清阳
 * @Email 1277409109@qq.com
 * @date 2019/8/10 18:02
 */
@Controller
@RequestMapping("manufacture")
public class ManufactureController {
    @Autowired
    ManufactureService manufactureService;

    @RequestMapping("get_data")
    @ResponseBody
    public List<Manufacture> get_data(){
        List<Manufacture> manufactures= manufactureService.selectByExample( new ManufactureExample());
        return  manufactures;
    }
    @RequestMapping("find")
    public String find(){
        return  "manufacture_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public PageBean<Manufacture> list(int page, int rows){
        List<Manufacture> manufactures = manufactureService.findAllManufacture( page,rows);
        //查询到的数据给到PageInfo  pagehelper的封装的对象，只需要把结果集给到该对象，
        // 就可以通过该对象get方法拿到总页数，总记录数，
        PageInfo<Manufacture> pageInfo=new PageInfo<>(manufactures);
        //在自定义一个分页对象，就可以传入页面需要的list集合，和total，同时json形式返回
        PageBean<Manufacture> pageBean=new PageBean<>(manufactures,pageInfo.getTotal());

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
    public Map update_note(Manufacture manufacture){
        int i = manufactureService.updateByPrimaryKeySelective(manufacture);
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
        return   "manufacture_edit";
    }
    //修改全部信息操作
    @RequestMapping("update_all")
    @ResponseBody
    public Map update_all(Manufacture manufacture){
        int i = manufactureService.updateByPrimaryKey(manufacture);
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
        return   "manufacture_add";
    }
    //插入信息操作
    @RequestMapping("insert")
    @ResponseBody
    public Map insert(Manufacture manufacture){
        int i = manufactureService.insert(manufacture);
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
        ManufactureExample manufactureExample=new ManufactureExample();
        //将ids字符串转换为字符数组
        String[] split = ids.split(",");
        //把ids数组封装andCustomIdIn，需要的list参数
        List<String> list=new ArrayList<>(Arrays.asList(split));
        //封装条件
        manufactureExample.createCriteria().andManufactureSnIn(list);

        int i = manufactureService.deleteByExample(manufactureExample);
        Map<String,Object> map=new HashMap<>();
        if (i!=0){
            map.put("status","200");
        }else {
            map.put("status","302");
        }
        return  map ;
    }
    //通过id查询manufacture
    @RequestMapping("get/{id}")
    @ResponseBody
    public Manufacture get(@PathVariable String id){
        Manufacture manufacture = manufactureService.selectByPrimaryKey(id);
        return manufacture;
    }

    //模糊查询search_manufacture_by_manufactureSn，manufactureOrderId,manufactureTechnologyName
    @RequestMapping("search_manufacture_by_manufactureSn")
    @ResponseBody
    public PageBean<Manufacture> search_manufacture_by_manufactureSn(int page,int rows,String searchValue){
        ManufactureExample manufactureExample = new ManufactureExample();
        manufactureExample.createCriteria().andManufactureSnLike("%"+searchValue+"%");
        List<Manufacture> manufactures = manufactureService.findAllManufactureByIdOrOrderId( page,rows,manufactureExample);
        //查询到的数据给到PageInfo  pagehelper的封装的对象，只需要把结果集给到该对象，
        // 就可以通过该对象get方法拿到总页数，总记录数，
        PageInfo<Manufacture> pageInfo=new PageInfo<>(manufactures);
        //在自定义一个分页对象，就可以传入页面需要的list集合，和total，同时json形式返回
        PageBean<Manufacture> pageBean=new PageBean<>(manufactures,pageInfo.getTotal());

        return  pageBean;
    }
    @RequestMapping("search_manufacture_by_manufactureOrderId")
    @ResponseBody
    public PageBean<Manufacture> search_manufacture_by_manufactureOrderId(int page,int rows,String searchValue){
        ManufactureExample manufactureExample = new ManufactureExample();
        manufactureExample.createCriteria().andOrderIdLike("%"+searchValue+"%");
        List<Manufacture> manufactures = manufactureService.findAllManufactureByIdOrOrderId( page,rows,manufactureExample);
        //查询到的数据给到PageInfo  pagehelper的封装的对象，只需要把结果集给到该对象，
        // 就可以通过该对象get方法拿到总页数，总记录数，
        PageInfo<Manufacture> pageInfo=new PageInfo<>(manufactures);
        //在自定义一个分页对象，就可以传入页面需要的list集合，和total，同时json形式返回
        PageBean<Manufacture> pageBean=new PageBean<>(manufactures,pageInfo.getTotal());

        return  pageBean;
    }
    @RequestMapping("search_manufacture_by_manufactureTechnologyName")
    @ResponseBody
    public PageBean<Manufacture> search_manufacture_by_manufactureTechnologyName(int page,int rows,String searchValue){
        List<Manufacture> manufactures = manufactureService.findAllManufactureByTechnologyName( page,rows,"%"+searchValue+"%");
        //查询到的数据给到PageInfo  pagehelper的封装的对象，只需要把结果集给到该对象，
        // 就可以通过该对象get方法拿到总页数，总记录数，
        PageInfo<Manufacture> pageInfo=new PageInfo<>(manufactures);
        //在自定义一个分页对象，就可以传入页面需要的list集合，和total，同时json形式返回
        PageBean<Manufacture> pageBean=new PageBean<>(manufactures,pageInfo.getTotal());

        return  pageBean;
    }
}
