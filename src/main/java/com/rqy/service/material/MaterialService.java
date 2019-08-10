package com.rqy.service.material;

import com.rqy.domain.Material;
import com.rqy.domain.MaterialExample;

import java.util.List;

public interface MaterialService {

    List<Material> selectByExample(MaterialExample example);

    Material selectByPrimaryKey(String materialId);

    List<Material> findAllMaterial(int page,int rows);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);

    int deleteByExample(MaterialExample example);

    int insert(Material record);

    List<Material> findAllMaterialByIdOrName(int page,int rows,MaterialExample example);
}
