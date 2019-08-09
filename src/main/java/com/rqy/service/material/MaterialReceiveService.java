package com.rqy.service.material;

import com.rqy.domain.MaterialReceive;
import com.rqy.domain.MaterialReceiveExample;

import java.util.List;

public interface MaterialReceiveService {
    List<MaterialReceive> selectByExample(MaterialReceiveExample example);
}
