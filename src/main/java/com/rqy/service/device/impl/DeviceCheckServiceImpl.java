package com.rqy.service.device.impl;

import com.rqy.domain.DeviceCheck;
import com.rqy.domain.DeviceCheckExample;
import com.rqy.mapper.DeviceCheckMapper;
import com.rqy.service.device.DeviceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeviceCheckServiceImpl implements DeviceCheckService {
    @Autowired
    DeviceCheckMapper deviceCheckMapper;
    @Override
    public long countByExample(DeviceCheckExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String deviceId) {
        return deviceCheckMapper.deleteByPrimaryKey(deviceId);
    }

    @Override
    public int insert(DeviceCheck record) {
        return deviceCheckMapper.insert(record);
    }

    @Override
    public List<DeviceCheck> selectByExample(DeviceCheckExample deviceExample) {
        return deviceCheckMapper.selectByExample(deviceExample);
    }

    @Override
    public List<DeviceCheck> selectByLike(String deviceName) {
        return deviceCheckMapper.selectByLike(deviceName);
    }

    @Override
    public DeviceCheck selectByPrimaryKey(String deviceId) {
        return null;
    }

    @Override
    public int updateByPrimaryKey(DeviceCheck record) {
        return deviceCheckMapper.updateByPrimaryKey(record);
    }
}
