package com.rqy.service;

import com.github.pagehelper.PageHelper;
import com.rqy.domain.Custom;
import com.rqy.domain.CustomExample;
import com.rqy.mapper.CustomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 任清阳
 * @Email 1277409109@qq.com
 * @date 2019/8/8 18:27
 */
@Component
public class CustomServiceImpl implements CustomService {
    @Autowired
    CustomMapper customMapper;

    @Override
    public Custom selectByPrimaryKey(String customId) {
        return customMapper.selectByPrimaryKey(customId);
    }

    @Override
    public List<Custom> selectByExample(CustomExample example) {
        return customMapper.selectByExample(example);
    }

    /**
     * page 开始页数
     * rows 每页显示的数据条数
     */
    @Override
    public List<Custom> findAllCustom(int page,int rows) {
        //将参数传给方法实现分页
        PageHelper.startPage(page, rows);
        CustomExample example = new CustomExample();
        List<Custom> customs = customMapper.selectByExample(example);
        return customs;
    }
    //模糊查询的方法
    @Override
    public List<Custom> findAllCustomByIdOrName(int page, int rows, CustomExample example) {
        //将参数传给方法实现分页
        PageHelper.startPage(page, rows);
        List<Custom> customs = customMapper.selectByExample(example);
        return customs;
    }

    @Override
    public int updateByPrimaryKeySelective(Custom record) {
        return customMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Custom record) {
        return customMapper.updateByPrimaryKey(record);
    }

    @Override
    public int insert(Custom record) {
        return customMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(String customId) {
        return customMapper.deleteByPrimaryKey(customId);
    }

    @Override
    public int deleteByExample(CustomExample example) {
        return customMapper.deleteByExample(example);
    }
}
