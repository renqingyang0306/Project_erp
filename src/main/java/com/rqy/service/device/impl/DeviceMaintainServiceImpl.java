package com.rqy.service.device.impl;

import com.rqy.domain.DeviceMaintain;
import com.rqy.domain.DeviceMaintainExample;
import com.rqy.mapper.DeviceMaintainMapper;
import com.rqy.service.device.DeviceMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeviceMaintainServiceImpl implements DeviceMaintainService {

    @Autowired
    DeviceMaintainMapper deviceMaintainMapper;
    @Override
    public long countByExample(DeviceMaintainExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String deviceId) {
        return deviceMaintainMapper.deleteByPrimaryKey(deviceId);
    }

    @Override
    public int insert(DeviceMaintain record) {
        return deviceMaintainMapper.insert(record);
    }

    @Override
    public List<DeviceMaintain> selectByExample(DeviceMaintainExample deviceExample) {
        return deviceMaintainMapper.selectByExample(deviceExample);
    }

    @Override
    public DeviceMaintain selectByPrimaryKey(String deviceId) {
        return null;
    }

    @Override
    public int updateByPrimaryKey(DeviceMaintain record) {
        return deviceMaintainMapper.updateByPrimaryKey(record);
    }


}
