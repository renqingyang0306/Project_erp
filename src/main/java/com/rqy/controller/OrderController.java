package com.rqy.controller;

import com.github.pagehelper.PageInfo;
import com.rqy.domain.COrder;
import com.rqy.domain.COrderExample;
import com.rqy.domain.Custom;
import com.rqy.service.OrderService;
import com.rqy.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @author 任清阳
 * @Email 1277409109@qq.com
 * @date 2019/8/9 20:03
 */
@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("find")
    public String find(){
        return  "order_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public PageBean<COrder> list(int page, int rows){
        List<COrder> cOrders = orderService.findAllOrder( page,rows);
        //查询到的数据给到PageInfo  pagehelper的封装的对象，只需要把结果集给到该对象，
        // 就可以通过该对象get方法拿到总页数，总记录数，
        PageInfo<COrder> pageInfo=new PageInfo<>(cOrders);
        //在自定义一个分页对象，就可以传入页面需要的list集合，和total，同时json形式返回
        PageBean<COrder> pageBean=new PageBean<>(cOrders,pageInfo.getTotal());

        return  pageBean;
    }
    //模糊查询search_order_by_orderId，orderCustom,orderProduct
    @RequestMapping("search_order_by_orderId")
    @ResponseBody
    public PageBean<COrder> search_order_by_orderId(int page,int rows,String searchValue){
        COrderExample cOrderExample = new COrderExample();
        cOrderExample.createCriteria().andOrderIdLike("%"+searchValue+"%");
        List<COrder> cOrders = orderService.findAllOrderById( page,rows,cOrderExample);
        //查询到的数据给到PageInfo  pagehelper的封装的对象，只需要把结果集给到该对象，
        // 就可以通过该对象get方法拿到总页数，总记录数，
        PageInfo<COrder> pageInfo=new PageInfo<>(cOrders);
        //在自定义一个分页对象，就可以传入页面需要的list集合，和total，同时json形式返回
        PageBean<COrder> pageBean=new PageBean<>(cOrders,pageInfo.getTotal());

        return  pageBean;
    }
    /*@RequestMapping("search_order_by_orderCustom")
    @ResponseBody
    public PageBean<COrder> search_order_by_orderCustom(int page,int rows,String searchValue){
        List<COrder> cOrders = orderService.findAllOrderByCustomName( page,rows,searchValue);
        //查询到的数据给到PageInfo  pagehelper的封装的对象，只需要把结果集给到该对象，
        // 就可以通过该对象get方法拿到总页数，总记录数，
        PageInfo<COrder> pageInfo=new PageInfo<>(cOrders);
        //在自定义一个分页对象，就可以传入页面需要的list集合，和total，同时json形式返回
        PageBean<COrder> pageBean=new PageBean<>(cOrders,pageInfo.getTotal());

        return  pageBean;
    }*/
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
    public Map update_note(COrder order){
        int i = orderService.updateByPrimaryKeySelective(order);
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
        return   "order_edit";
    }
    //修改全部信息操作
    @RequestMapping("update_all")
    @ResponseBody
    public Map update_all(COrder order){
        int i = orderService.updateByPrimaryKey(order);
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
        return   "order_add";
    }
    //插入信息操作
    @RequestMapping("insert")
    @ResponseBody
    public Map insert(COrder order){
        int i = orderService.insert(order);
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
        COrderExample cOrderExample=new COrderExample();
        //将ids字符串转换为字符数组
        String[] split = ids.split(",");
        //把ids数组封装andCustomIdIn，需要的list参数
        List<String> list=new ArrayList<>(Arrays.asList(split));
        //封装条件
        cOrderExample.createCriteria().andOrderIdIn(list);

        int i = orderService.deleteByExample(cOrderExample);
        Map<String,Object> map=new HashMap<>();
        if (i!=0){
            map.put("status","200");
        }else {
            map.put("status","302");
        }
        return  map ;
    }

}
