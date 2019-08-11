package com.rqy.service.device;

import com.rqy.domain.Device;
import com.rqy.domain.DeviceExample;
import com.rqy.domain.DeviceType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
public interface DeviceService {
    long countByExample(DeviceExample example);

    int deleteByPrimaryKey(String deviceId);

    int insert(Device record);

    List<Device> selectByExample(DeviceExample deviceExample);
    List<Device> selectByLikeName(String deviceName);
    List<Device> selectByLike(String deviceTypeName);

    Device selectByPrimaryKey(String deviceId);

    int updateByPrimaryKey(Device record);



}
