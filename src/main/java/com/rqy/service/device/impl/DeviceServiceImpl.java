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







/*

    //第一栏
    @Override
    public List<Device> selectAllDeviceList(int page, int row) {
       page = (page - 1) * 20;
        List<Device> devices = deviceMapper.selectAll(page, row);
        return devices;
    }

    @Override
    public long countAllDeviceList() {
        return deviceMapper.countAll();
    }

    @Override
    public int insertDeviceList(Device device) {
        int insert = deviceMapper.insert(device);
        return insert;
    }

    @Override
    public void updateByPrimaryKeySelectiveDeviceList(Device device) {
        deviceMapper.updateByPrimaryKeySelective(device);
    }

    @Override
    public void deleteByPrimaryKeyDeviceList(String deviceId) {
        deviceMapper.deleteByPrimaryKey(deviceId);
    }


    //第二栏
    @Override
    public List<DeviceType> selectAllDeviceType(int page, int row) {
        page = (page - 1) * 20;
        List<DeviceType> devices = deviceTypeMapper.selectAll(page, row);
        return devices;
    }

    @Override
    public long countAllDeviceType() {
        return deviceTypeMapper.countAll();
    }

    @Override
    public int insertDeviceType(DeviceType deviceType) {
        int i = deviceTypeMapper.updateByPrimaryKeySelective(deviceType);
        return i;
    }

    @Override
    public void updateByPrimaryKeySelectiveDeviceType(DeviceType deviceType) {
        deviceTypeMapper.updateByPrimaryKeySelective(deviceType);

    }

    @Override
    public void deleteByPrimaryKeyDeviceType(String deviceId) {
        deviceTypeMapper.deleteByPrimaryKey(deviceId);
    }

*/




}
