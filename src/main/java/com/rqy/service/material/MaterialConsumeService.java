package com.rqy.service.material;

import com.rqy.domain.MaterialConsume;
import com.rqy.domain.MaterialConsumeExample;

import java.util.List;

public interface MaterialConsumeService {
    List<MaterialConsume> selectByExample(MaterialConsumeExample example);
}
