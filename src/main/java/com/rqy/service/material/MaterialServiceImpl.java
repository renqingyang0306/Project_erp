package com.rqy.service.material;

import com.rqy.domain.Material;
import com.rqy.domain.MaterialExample;
import com.rqy.mapper.MaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    MaterialMapper materialMapper;

    @Override
    public List<Material> selectByExample(MaterialExample example) {
        List<Material> materials = materialMapper.selectByExample(example);
        return materials;
    }

    @Override
    public Material selectByPrimaryKey(String materialId) {
        return materialMapper.selectByPrimaryKey(materialId);
    }

}
