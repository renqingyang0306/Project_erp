package com.rqy.service.material;

import com.rqy.domain.Material;
import com.rqy.domain.MaterialExample;

import java.util.List;

public interface MaterialService {

    List<Material> selectByExample(MaterialExample example);
    Material selectByPrimaryKey(String materialId);
}
