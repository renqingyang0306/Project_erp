package com.rqy.service.device;


import com.rqy.domain.DeviceCheck;
import com.rqy.domain.DeviceCheckExample;

import java.util.List;

public interface DeviceCheckService {

    long countByExample(DeviceCheckExample example);

    int deleteByPrimaryKey(String deviceId);

    int insert(DeviceCheck record);

    List<DeviceCheck> selectByExample(DeviceCheckExample deviceExample);
    List<DeviceCheck> selectByLike(String deviceTypeName);

    DeviceCheck selectByPrimaryKey(String deviceName);

    int updateByPrimaryKey(DeviceCheck record);

}
