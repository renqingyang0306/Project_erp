package com.rqy.service.material;

import com.rqy.domain.MaterialReceive;
import com.rqy.domain.MaterialReceiveExample;

import java.util.List;

public interface MaterialReceiveService {
    List<MaterialReceive> selectByExample(MaterialReceiveExample example);

    List<MaterialReceive> findAllMaterial(int page,int rows);

    int insert(MaterialReceive record);

    int deleteByExample(MaterialReceiveExample example);
}
