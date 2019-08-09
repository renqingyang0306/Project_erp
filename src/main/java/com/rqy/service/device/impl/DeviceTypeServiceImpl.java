package com.rqy.service.device.impl;

import com.rqy.domain.DeviceType;
import com.rqy.domain.DeviceTypeExample;
import com.rqy.mapper.DeviceTypeMapper;
import com.rqy.service.device.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {
    @Autowired
    DeviceTypeMapper deviceTypeMapper;

    @Override
    public long countByExample(DeviceTypeExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String deviceId) {
        return deviceTypeMapper.deleteByPrimaryKey(deviceId);
    }

    @Override
    public int insert(DeviceType record) {
        return deviceTypeMapper.insert(record);
    }

    @Override
    public List<DeviceType> selectByExample(DeviceTypeExample deviceExample) {
        return deviceTypeMapper.selectByExample(deviceExample);
    }

    @Override
    public DeviceType selectByPrimaryKey(String deviceId) {
        return null;
    }

    @Override
    public int updateByPrimaryKey(DeviceType record) {
        return updateByPrimaryKey(record);
    }
}
