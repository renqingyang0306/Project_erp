package com.rqy.controller;

import com.rqy.domain.Product;
import com.rqy.domain.ProductExample;
import com.rqy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
}
