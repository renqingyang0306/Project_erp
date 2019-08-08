package com.rqy.service.material;

import com.rqy.domain.MaterialConsume;
import com.rqy.domain.MaterialConsumeExample;
import com.rqy.mapper.MaterialConsumeMapper;
import com.rqy.service.material.MaterialConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialConsumeServiceImpl implements MaterialConsumeService {
    @Autowired
    MaterialConsumeMapper materialConsumeMapper;

    @Override
    public List<MaterialConsume> selectByExample(MaterialConsumeExample example) {
        List<MaterialConsume> materialConsumes = materialConsumeMapper.selectByExample(example);
        return materialConsumes;
    }
}
