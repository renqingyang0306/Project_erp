package com.rqy.service.material;

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
}
