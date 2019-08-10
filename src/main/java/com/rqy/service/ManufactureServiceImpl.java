package com.rqy.service;

import com.github.pagehelper.PageHelper;
import com.rqy.domain.Manufacture;
import com.rqy.domain.ManufactureExample;
import com.rqy.mapper.ManufactureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 任清阳
 * @Email 1277409109@qq.com
 * @date 2019/8/10 18:06
 */
@Component
public class ManufactureServiceImpl implements ManufactureService {
    @Autowired
    ManufactureMapper manufactureMapper;
    @Override
    public int deleteByExample(ManufactureExample example) {
        return manufactureMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String manufactureSn) {
        return manufactureMapper.deleteByPrimaryKey(manufactureSn);
    }

    @Override
    public int insert(Manufacture record) {
        return manufactureMapper.insert(record);
    }

    @Override
    public List<Manufacture> selectByExample(ManufactureExample example) {
        return manufactureMapper.selectByExample(example);
    }

    @Override
    public Manufacture selectByPrimaryKey(String manufactureSn) {
        return manufactureMapper.selectByPrimaryKey(manufactureSn);
    }

    @Override
    public int updateByPrimaryKeySelective(Manufacture record) {
        return manufactureMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Manufacture record) {
        return manufactureMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Manufacture> findAllManufacture(int page, int rows) {
        PageHelper.startPage(page,rows);
        ManufactureExample manufactureExample=new ManufactureExample();
        return manufactureMapper.selectByExample(manufactureExample);
    }

    @Override
    public List<Manufacture> findAllManufactureByIdOrOrderId(int page, int rows, ManufactureExample manufactureExample) {
        PageHelper.startPage(page,rows);
        List<Manufacture> manufactures = manufactureMapper.selectByExample(manufactureExample);
        return manufactures;
    }

    @Override
    public List<Manufacture> findAllManufactureByTechnologyName(int page, int rows, String s) {
        PageHelper.startPage(page,rows);
        List<Manufacture> manufactures = manufactureMapper.findAllManufactureByTechnologyName(s);
        return manufactures;
    }
}
