package com.rqy.controller;

import com.github.pagehelper.PageInfo;
import com.rqy.domain.Product;
import com.rqy.domain.ProductExample;
import com.rqy.service.ProductService;
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
 * @date 2019/8/9 20:09
 */
@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;

    //客户信息，用于查询查询全部数据填充下拉列表的
    @RequestMapping("get_data")
    @ResponseBody
    public List<Product> get_data(){
        List<Product> products = productService.selectByExample( new ProductExample());
        return  products;
    }
    @RequestMapping("find")
    public String find(){
        return  "product_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public PageBean<Product> list(int page, int rows){
        List<Product> products = productService.findAllProduct( page,rows);
        //查询到的数据给到PageInfo  pagehelper的封装的对象，只需要把结果集给到该对象，
        // 就可以通过该对象get方法拿到总页数，总记录数，
        PageInfo<Product> pageInfo=new PageInfo<>(products);
        //在自定义一个分页对象，就可以传入页面需要的list集合，和total，同时json形式返回
        PageBean<Product> pageBean=new PageBean<>(products,pageInfo.getTotal());

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
    public Map update_note(Product order){
        int i = productService.updateByPrimaryKeySelective(order);
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
        return   "product_edit";
    }
    //修改全部信息操作
    @RequestMapping("update_all")
    @ResponseBody
    public Map update_all(Product order){
        int i = productService.updateByPrimaryKey(order);
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
        return   "product_add";
    }
    //插入信息操作
    @RequestMapping("insert")
    @ResponseBody
    public Map insert(Product product){
        int i = productService.insert(product);
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
        ProductExample productExample=new ProductExample();
        //将ids字符串转换为字符数组
        String[] split = ids.split(",");
        //把ids数组封装andCustomIdIn，需要的list参数
        List<String> list=new ArrayList<>(Arrays.asList(split));
        //封装条件
        productExample.createCriteria().andProductIdIn(list);

        int i = productService.deleteByExample(productExample);
        Map<String,Object> map=new HashMap<>();
        if (i!=0){
            map.put("status","200");
        }else {
            map.put("status","302");
        }
        return  map ;
    }
    //通过id查询Product
    @RequestMapping("get/{id}")
    @ResponseBody
    public Product get(@PathVariable String id){
        Product product = productService.selectByPrimaryKey(id);
        return product;
    }
    //模糊查询search_product_by__productId，productName,productType
    @RequestMapping("search_product_by_productId")
    @ResponseBody
    public PageBean<Product> search_product_by_productId(int page,int rows,String searchValue){
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andProductIdLike("%"+searchValue+"%");
        List<Product> products = productService.findAllProductByIdOrNameOrType( page,rows,productExample);
        //查询到的数据给到PageInfo  pagehelper的封装的对象，只需要把结果集给到该对象，
        // 就可以通过该对象get方法拿到总页数，总记录数，
        PageInfo<Product> pageInfo=new PageInfo<>(products);
        //在自定义一个分页对象，就可以传入页面需要的list集合，和total，同时json形式返回
        PageBean<Product> pageBean=new PageBean<>(products,pageInfo.getTotal());
        return  pageBean;
    }
    //模糊查询search_product_by__productId，productName,productType
    @RequestMapping("search_product_by_productName")
    @ResponseBody
    public PageBean<Product> search_product_by_productName(int page,int rows,String searchValue){
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andProductNameLike("%"+searchValue+"%");
        List<Product> products = productService.findAllProductByIdOrNameOrType( page,rows,productExample);
        //查询到的数据给到PageInfo  pagehelper的封装的对象，只需要把结果集给到该对象，
        // 就可以通过该对象get方法拿到总页数，总记录数，
        PageInfo<Product> pageInfo=new PageInfo<>(products);
        //在自定义一个分页对象，就可以传入页面需要的list集合，和total，同时json形式返回
        PageBean<Product> pageBean=new PageBean<>(products,pageInfo.getTotal());
        return  pageBean;
    }
    //模糊查询search_product_by__productId，productName,productType
    @RequestMapping("search_product_by_productType")
    @ResponseBody
    public PageBean<Product> search_product_by_productType(int page,int rows,String searchValue){
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andProductTypeLike("%"+searchValue+"%");
        List<Product> products = productService.findAllProductByIdOrNameOrType( page,rows,productExample);
        //查询到的数据给到PageInfo  pagehelper的封装的对象，只需要把结果集给到该对象，
        // 就可以通过该对象get方法拿到总页数，总记录数，
        PageInfo<Product> pageInfo=new PageInfo<>(products);
        //在自定义一个分页对象，就可以传入页面需要的list集合，和total，同时json形式返回
        PageBean<Product> pageBean=new PageBean<>(products,pageInfo.getTotal());
        return  pageBean;
    }
}
