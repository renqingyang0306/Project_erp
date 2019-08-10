package com.rqy.service.material;

import com.github.pagehelper.PageHelper;
import com.rqy.domain.MaterialConsume;
import com.rqy.domain.MaterialConsumeExample;
import com.rqy.domain.MaterialReceive;
import com.rqy.mapper.MaterialConsumeMapper;
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

    @Override
    public List<MaterialConsume> findAllMaterialConsume(int page, int rows) {
        PageHelper.startPage(page,rows);
        MaterialConsumeExample example = new MaterialConsumeExample();
        List<MaterialConsume> consumes = materialConsumeMapper.selectByExample(example);
        for (MaterialConsume consume : consumes) {
            consume.setWorkId("001");
        }
        return consumes;
    }

    @Override
    public int insert(MaterialConsume record) {
        return materialConsumeMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(String consumeId) {
        return materialConsumeMapper.deleteByPrimaryKey(consumeId);
    }

    @Override
    public int updateByPrimaryKeySelective(MaterialConsume record) {
        return materialConsumeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MaterialConsume record) {
        return materialConsumeMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<MaterialConsume> findAllMaterialConsumeByConsumeidOrWorkidOrMaterialid(int page, int rows, MaterialConsumeExample example) {
        PageHelper.startPage(page,rows);
        List<MaterialConsume> materialConsumes = materialConsumeMapper.selectByExample(example);
        return materialConsumes;
    }
}
