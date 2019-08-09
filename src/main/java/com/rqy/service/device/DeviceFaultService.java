package com.rqy.service.device;

import com.rqy.domain.DeviceFault;
import com.rqy.domain.DeviceFaultExample;

import java.util.List;

public interface DeviceFaultService {
    long countByExample(DeviceFaultExample example);

    int deleteByPrimaryKey(String deviceId);

    int insert(DeviceFault record);

    List<DeviceFault> selectByExample(DeviceFaultExample deviceExample);
    List<DeviceFault> selectByLike(String deviceTypeName);

    DeviceFault selectByPrimaryKey(String deviceId);

    int updateByPrimaryKey(DeviceFault record);
}
