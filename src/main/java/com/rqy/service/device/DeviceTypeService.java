package com.rqy.service.device;

import com.rqy.domain.DeviceType;
import com.rqy.domain.DeviceTypeExample;

import java.util.List;

public interface DeviceTypeService {
    long countByExample(DeviceTypeExample example);

    int deleteByPrimaryKey(String deviceId);

    int insert(DeviceType record);

    List<DeviceType> selectByExample(DeviceTypeExample deviceExample);

    DeviceType selectByPrimaryKey(String deviceId);

    int updateByPrimaryKey(DeviceType record);
}
