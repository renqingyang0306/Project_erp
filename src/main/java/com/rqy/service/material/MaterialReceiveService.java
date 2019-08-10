package com.rqy.service.material;

import com.rqy.domain.MaterialExample;
import com.rqy.domain.MaterialReceive;
import com.rqy.domain.MaterialReceiveExample;

import java.util.List;

public interface MaterialReceiveService {
    List<MaterialReceive> selectByExample(MaterialReceiveExample example);

    List<MaterialReceive> findAllMaterial(int page,int rows);

    int insert(MaterialReceive record);

    int deleteByExample(MaterialReceiveExample example);

    int updateByPrimaryKeySelective(MaterialReceive record);

    int updateByPrimaryKey(MaterialReceive record);

    int deleteByPrimaryKey(String receiveId);

    List<MaterialReceive> findAllMaterialReceiveByReceiveidOrMaterialid(int page, int rows, MaterialReceiveExample example);
}
