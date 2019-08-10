package com.rqy.service;

import com.rqy.domain.COrder;
import com.rqy.domain.COrderExample;

import java.util.List;

/**
 * @author 任清阳
 * @Email 1277409109@qq.com
 * @date 2019/8/9 20:13
 */
public interface OrderService {
    List<COrder> findAllOrder(int page, int rows);
    int deleteByExample(COrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(COrder record);

    COrder selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(COrder record);

    int updateByPrimaryKey(COrder record);

    List<COrder> findAllOrderById(int page, int rows, COrderExample cOrderExample);

    List<COrder> findAllOrderByCustomName(int page, int rows, String searchValue);

    List<COrder> findAllOrderByProductName(int page, int rows, String s);

    List<COrder> selectByExample(COrderExample cOrderExample);
}
