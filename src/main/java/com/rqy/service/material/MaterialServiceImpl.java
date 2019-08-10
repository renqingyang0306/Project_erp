package com.rqy.service.material;

import com.github.pagehelper.PageHelper;
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


    /**
     * page 开始页数
     * rows 每页显示的数据数
     * */
    @Override
    public List<Material> findAllMaterial(int page, int rows) {
        PageHelper.startPage(page,rows);
        MaterialExample materialExample = new MaterialExample();
        List<Material> materials = materialMapper.selectByExample(materialExample);
        return materials;
    }

    @Override
    public int updateByPrimaryKeySelective(Material record) {
        return materialMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Material record) {
        return materialMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByExample(MaterialExample example) {
        return materialMapper.deleteByExample(example);
    }

    @Override
    public int insert(Material record) {
        return materialMapper.insert(record);
    }

    @Override
    public List<Material> findAllMaterialByIdOrName(int page, int rows, MaterialExample example) {
        PageHelper.startPage(page,rows);
        List<Material> materials = materialMapper.selectByExample(example);
        return materials;
    }

}
