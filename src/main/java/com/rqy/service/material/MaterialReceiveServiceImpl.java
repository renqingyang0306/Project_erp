package com.rqy.service.material;

import com.github.pagehelper.PageHelper;
import com.rqy.domain.MaterialReceive;
import com.rqy.domain.MaterialReceiveExample;
import com.rqy.mapper.MaterialReceiveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialReceiveServiceImpl implements MaterialReceiveService {
    @Autowired
    MaterialReceiveMapper materialReceiveMapper;

    @Override
    public List<MaterialReceive> selectByExample(MaterialReceiveExample example) {
        List<MaterialReceive> materialReceives = materialReceiveMapper.selectByExample(example);
        return materialReceives;
    }

    /**
     * page 开始页数
     * rows 每页显示的数据数
     * */
    @Override
    public List<MaterialReceive> findAllMaterial(int page, int rows) {
        PageHelper.startPage(page,rows);
        MaterialReceiveExample example = new MaterialReceiveExample();
        List<MaterialReceive> materialReceives = materialReceiveMapper.selectByExample(example);
        return materialReceives;
    }

    @Override
    public int insert(MaterialReceive record) {
        return materialReceiveMapper.insert(record);
    }

    @Override
    public int deleteByExample(MaterialReceiveExample example) {
        return materialReceiveMapper.deleteByExample(example);
    }
}
