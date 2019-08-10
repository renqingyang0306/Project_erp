package com.rqy.service;

import com.github.pagehelper.PageHelper;
import com.rqy.domain.Product;
import com.rqy.domain.ProductExample;
import com.rqy.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 任清阳
 * @Email 1277409109@qq.com
 * @date 2019/8/9 22:14
 */
@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public int deleteByExample(ProductExample example) {
        return productMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String productId) {
        return productMapper.deleteByPrimaryKey(productId);
    }

    @Override
    public int insert(Product record) {
        return productMapper.insert(record);
    }

    @Override
    public List<Product> selectByExample(ProductExample example) {
        return productMapper.selectByExample(example);
    }

    @Override
    public Product selectByPrimaryKey(String productId) {
        return productMapper.selectByPrimaryKey(productId);
    }

    @Override
    public int updateByPrimaryKeySelective(Product record) {
        return updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Product record) {
        return productMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Product> findAllProduct(int page, int rows) {
        //将参数传给方法实现分页
        PageHelper.startPage(page, rows);
        ProductExample productExample=new ProductExample();
        List<Product> products = productMapper.selectByExample(productExample);
        return products;
    }

    @Override
    public List<Product> findAllProductByIdOrNameOrType(int page, int rows, ProductExample productExample) {
        PageHelper.startPage(page,rows);
        List<Product> products = productMapper.selectByExample(productExample);
        return products;
    }
}
