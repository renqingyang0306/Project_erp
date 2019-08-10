package com.rqy.service;

import com.github.pagehelper.PageHelper;
import com.rqy.domain.COrder;
import com.rqy.domain.COrderExample;
import com.rqy.domain.Custom;
import com.rqy.domain.CustomExample;
import com.rqy.mapper.COrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 任清阳
 * @Email 1277409109@qq.com
 * @date 2019/8/9 20:13
 */
@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    COrderMapper cOrderMapper;
    @Override
    public List<COrder> findAllOrder(int page, int rows) {
        //将参数传给方法实现分页
        PageHelper.startPage(page, rows);
        COrderExample example = new COrderExample();
        List<COrder> cOrders = cOrderMapper.selectByExample(example);
        return cOrders;
    }

    @Override
    public int deleteByExample(COrderExample example) {
        return cOrderMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String orderId) {
        return cOrderMapper.deleteByPrimaryKey(orderId);
    }

    @Override
    public int insert(COrder record) {
        return cOrderMapper.insert(record);
    }

    @Override
    public COrder selectByPrimaryKey(String orderId) {
        return selectByPrimaryKey(orderId);
    }

    @Override
    public int updateByPrimaryKeySelective(COrder record) {
        return cOrderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(COrder record) {
        return cOrderMapper.updateByPrimaryKey(record);
    }
    @Override

    public List<COrder> findAllOrderById(int page, int rows, COrderExample cOrderExample) {
        //将参数传给方法实现分页
        PageHelper.startPage(page, rows);
        List<COrder> cOrders = cOrderMapper.selectByExample(cOrderExample);
        return cOrders;
    }
}
