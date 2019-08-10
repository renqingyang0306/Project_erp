package com.rqy.service.material;

import com.rqy.domain.MaterialConsume;
import com.rqy.domain.MaterialConsumeExample;
import com.rqy.domain.MaterialReceive;


import java.util.List;

public interface MaterialConsumeService {
    List<MaterialConsume> selectByExample(MaterialConsumeExample example);

    List<MaterialConsume> findAllMaterialConsume(int page, int rows);

    int insert(MaterialConsume record);

    int deleteByPrimaryKey(String consumeId);

    int updateByPrimaryKeySelective(MaterialConsume record);

    int updateByPrimaryKey(MaterialConsume record);

    List<MaterialConsume> findAllMaterialConsumeByConsumeidOrWorkidOrMaterialid(int page,int rows,MaterialConsumeExample example);
}
