package com.rqy.service;

import com.rqy.domain.Product;
import com.rqy.domain.ProductExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 任清阳
 * @Email 1277409109@qq.com
 * @date 2019/8/9 22:13
 */
public interface ProductService {
    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(String productId);

    int insert(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(String productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}
