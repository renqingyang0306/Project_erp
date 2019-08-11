package com.rqy.service.device.impl;

import com.github.pagehelper.PageHelper;
import com.rqy.domain.Device;
import com.rqy.domain.DeviceExample;
import com.rqy.mapper.DeviceMapper;
import com.rqy.service.device.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    DeviceMapper deviceMapper;

    @Override
    public long countByExample(DeviceExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String deviceId) {
        return deviceMapper.deleteByPrimaryKey(deviceId);
    }

    @Override
    public int insert(Device record) {
        return deviceMapper.insert(record);
    }

    @Override
    public List<Device> selectByExample(DeviceExample deviceExample) {
        List<Device> devices = deviceMapper.selectByExample(deviceExample);
        return devices;
    }
    @Override
    public List<Device> selectByLikeName(String deviceName) {
        return deviceMapper.selectByLikeName(deviceName);
    }


    @Override
    public List<Device> selectByLike(String deviceTypeName) {
        return deviceMapper.selectByLike(deviceTypeName);
    }

    @Override
    public Device selectByPrimaryKey(String deviceId) {
        return null;
    }

    @Override
    public int updateByPrimaryKey(Device record) {
        return deviceMapper.updateByPrimaryKey(record);
    }

}
