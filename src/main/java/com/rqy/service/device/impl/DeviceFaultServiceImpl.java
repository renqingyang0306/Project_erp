package com.rqy.service.device.impl;

import com.rqy.domain.DeviceFault;
import com.rqy.domain.DeviceFaultExample;
import com.rqy.mapper.DeviceFaultMapper;
import com.rqy.service.device.DeviceFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeviceFaultServiceImpl implements DeviceFaultService {
    @Autowired
    DeviceFaultMapper deviceFaultMapper;

    @Override
    public long countByExample(DeviceFaultExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String deviceId) {
        return deviceFaultMapper.deleteByPrimaryKey(deviceId);
    }

    @Override
    public int insert(DeviceFault record) { return deviceFaultMapper.insert(record); }

    @Override
    public List<DeviceFault> selectByExample(DeviceFaultExample deviceExample) {
        return deviceFaultMapper.selectByExample(deviceExample);
    }

    @Override
    public List<DeviceFault> selectByLike(String deviceTypeName) {
        return deviceFaultMapper.selectByLike(deviceTypeName);
    }


    @Override
    public DeviceFault selectByPrimaryKey(String deviceId) {
        return null;
    }

    @Override
    public int updateByPrimaryKey(DeviceFault record) {
        return deviceFaultMapper.updateByPrimaryKey(record);
    }
}
