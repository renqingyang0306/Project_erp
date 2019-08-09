package com.rqy.service.device;

import com.rqy.domain.DeviceMaintain;
import com.rqy.domain.DeviceMaintainExample;

import java.util.List;

public interface DeviceMaintainService {
    long countByExample(DeviceMaintainExample example);

    int deleteByPrimaryKey(String deviceId);

    int insert(DeviceMaintain record);

    List<DeviceMaintain> selectByExample(DeviceMaintainExample deviceExample);

    DeviceMaintain selectByPrimaryKey(String deviceId);

    int updateByPrimaryKey(DeviceMaintain record);
}
