package com.rqy.controller.device;



import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rqy.domain.*;
import com.rqy.service.device.DeviceService;
import com.rqy.service.device.DeviceTypeService;
import com.rqy.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DeviceContorller {
    @Autowired
    DeviceService deviceService;
    DeviceTypeService deviceTypeService;
    @RequestMapping("/device/deviceList")
    public String find(){
        return "deviceList";
    }
   @RequestMapping("/deviceList/add_judge")
    public String findadd1(){
        return "deviceList_add";
    }
   @RequestMapping("/deviceList/add")
    public String findadd(){
        return "deviceList_add";
    }

    @RequestMapping("deviceList/edit_judge")
    public String findadd4(){
        return "deviceList_edit";
    }

    @RequestMapping("/deviceList/edit")
    public String findadd3(){
        return "deviceList_edit";}

        @ResponseBody
    @RequestMapping("deviceList/delete_judge")
    public String findadd5(){
        return "";
    }





    @RequestMapping("/deviceList/list")
    @ResponseBody
    public PageBean list(@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows){
        DeviceExample deviceExample = new DeviceExample();
        PageHelper.startPage(page, rows);
        List<Device> devices = deviceService.selectByExample(deviceExample);
        PageInfo<Device> pageInfo = new PageInfo<>(devices);

        long total = pageInfo.getTotal();

        PageBean pageResult = new PageBean();

        pageResult.setTotal(total);
        pageResult.setRows(devices);
        return pageResult;
    }


    @RequestMapping("/deviceList/search_device_by_deviceId")
    @ResponseBody
    public PageBean searchIdlist(@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows,
                                 @RequestParam(value = "searchValue") int searchValue){
        DeviceExample deviceExample = new DeviceExample();
        DeviceExample.Criteria criteria = deviceExample.createCriteria();
        criteria.andDeviceIdLike("%"+searchValue+"%");
        PageHelper.startPage(page, rows);
        List<Device> devices = deviceService.selectByExample(deviceExample);
        deviceExample.clear();
        PageInfo<Device> pageInfo = new PageInfo<>(devices);
        long total = pageInfo.getTotal();

        PageBean pageResult = new PageBean();

        pageResult.setTotal(total);
        pageResult.setRows(devices);
        return pageResult;
    }

    @RequestMapping("/deviceList/search_device_by_deviceTypeName")
    @ResponseBody
    public PageBean searchNamelist(@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows,
                                 @RequestParam(value = "searchValue") String searchValue){

        PageHelper.startPage(page, rows);
        searchValue = "%"+searchValue+"%";
        List<Device> devices = deviceService.selectByLike(searchValue);

        PageInfo<Device> pageInfo = new PageInfo<>(devices);

        long total = pageInfo.getTotal();

        PageBean pageResult = new PageBean();

        pageResult.setTotal(total);
        pageResult.setRows(devices);
        return pageResult;
    }



    //删
        @ResponseBody
        @RequestMapping("deviceList/delete_batch")
        public RespondMsg delete(String ids) {

            if (ids.contains(",")) {
                String[] split = ids.split(",");
                for (int i = 0; i < split.length; i++) {
                    deviceService.deleteByPrimaryKey(split[i]);
                }
                int result = 1;
                    return RespondMsg.createSusscess();
            } else {
                //如果不是数组
                deviceService.deleteByPrimaryKey(ids);
                int result1 = deviceService.deleteByPrimaryKey(ids);
                    return RespondMsg.createSusscess();
            }
        }
//改
    @ResponseBody
    @RequestMapping("deviceList/update")
    public RespondMsg update(Device device) {
        //插入用领域模型
        int i = deviceService.updateByPrimaryKey(device);
        if (i==1){
            return RespondMsg.createSusscess();
        }
        return  RespondMsg.createFail();
        }
//增
    @ResponseBody
    @RequestMapping("deviceList/insert")
    public RespondMsg insert(Device device) {
        //插入用领域模型
        int i = deviceService.insert(device);
        if (i==1){
            return RespondMsg.createSusscess();
        }
        return  RespondMsg.createFail();
    }

    @ResponseBody
    @RequestMapping("deviceList/get_data")
    public List<Device> searchNamelist(){
        DeviceExample deviceExample = new DeviceExample();
        DeviceExample.Criteria criteria = deviceExample.createCriteria();
        List<Device> devices = deviceService.selectByExample(deviceExample);
        return devices;
    }
    @ResponseBody
    @RequestMapping("deviceList/get/{id}")
    public Device searchName(@PathVariable("id") Integer id){
        DeviceExample deviceExample = new DeviceExample();
        DeviceExample.Criteria criteria = deviceExample.createCriteria();
        criteria.andDeviceIdEqualTo(id);
        List<Device> devices = deviceService.selectByExample(deviceExample);
        Device device = new Device();
        device =devices.get(0);
        return device;
    }
}



   /*@RequestMapping("/deviceList/search_device_by_deviceTypeName")
    @ResponseBody
    public PageBean searchNamelist(@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows,
                                   @RequestParam(value = "searchValue") String searchValue){
        DeviceExample deviceExample = new DeviceExample();
        DeviceExample.Criteria criteria = deviceExample.createCriteria();
        criteria.andDeviceTypeIdBetween(searchValue);
        PageHelper.startPage(page, rows);
        List<Device> devices = deviceService.selectByExample(deviceExample);
        PageInfo<Device> pageInfo = new PageInfo<>(devices);

        long total = pageInfo.getTotal();

        PageBean pageResult = new PageBean();

        pageResult.setTotal(total);
        pageResult.setRows(devices);
        return pageResult;
    }
}




/*
    @RequestMapping("/erp/deviceList/insert")
    public ReturnTextMsg insert(@ModelAttribute DeviceListVo deviceListVo){
        //插入用领域模型
        Device device = new Device();
        BeanUtils.copyProperties(deviceListVo,device);
        //插入成功if()
        if(deviceService.insertDeviceList(device) != 0 ) {
            return ReturnTextMsg.createBySuccessMessage();
        } //不成功返回ErrorMessage
        return ReturnTextMsg.createByErrorMessage();
    }




    @RequestMapping("/erp/deviceList/update")
    public ReturnTextMsg update(@ModelAttribute DeviceListVo deviceListVo){
        //更新
        Device device = new Device();
        BeanUtils.copyProperties(deviceListVo, device);
        deviceService.updateByPrimaryKeySelectiveDeviceList(device);
        return ReturnTextMsg.createBySuccessMessage();
    }




    @RequestMapping("/erp/deviceList/delete_batch")
    public ReturnTextMsg delete_batch(@RequestParam(value = "ids") String ids){
        //如果是数组
        if (ids.contains(",")) {
            String[] split = ids.split(",");
            for (int i = 0; i < split.length; i++) {
                deviceService.deleteByPrimaryKeyDeviceList(split[0]);
            }
        }else {
            //如果不是数组
            deviceService.deleteByPrimaryKeyDeviceList(ids);
        }
        return ReturnTextMsg.createBySuccessMessage();
        //不成功返回ErrorMessage
    }*/











   /* @RequestMapping("/erp/deviceType/list")
    public ReturnMessage deviceTypeList(@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows){
        // 1.数据库查多少条数据 total
        // 2.数据库查出每个对象，返回数组对象，用一个Array[object]接收 array
        //3.返回的是total，array
        List<DeviceType> devices = deviceService.selectAllDeviceType(page, rows);
        DeviceTypeListVo[] array = new DeviceTypeListVo[devices.size()];
        for (int i = 0; i < devices.size(); i++) {
            //把集合变数组
            BeanUtils.copyProperties(devices.get(i),array[i]);
        }
        //总条数
        int count = (int) deviceService.countAllDeviceType();
        return ReturnMessage.create(count,array);

    }
    @RequestMapping("/erp/deviceType/insert")
    public ReturnTextMsg insert(@ModelAttribute DeviceTypeListVo deviceTypeListVo){
        //插入用领域模型
        DeviceType deviceType = new DeviceType();
        BeanUtils.copyProperties(deviceTypeListVo,deviceType);
        //插入成功if()
        if(deviceService.insertDeviceType(deviceType) != 0 ) {
            return ReturnTextMsg.createBySuccessMessage();
        }
        return ReturnTextMsg.createByErrorMessage();
        //不成功返回ErrorMessage
    }
    @RequestMapping("/erp/deviceType/update")
    public ReturnTextMsg update(@ModelAttribute DeviceTypeListVo deviceTypeListVo){
        //如果成功，返回
        //插入成功if()
        DeviceType deviceType = new DeviceType();
        BeanUtils.copyProperties(deviceTypeListVo,deviceType);
        deviceService.updateByPrimaryKeySelectiveDeviceType(deviceType);
        return ReturnTextMsg.createBySuccessMessage();
        //不成功返回ErrorMessage
    }
    @RequestMapping("/erp/deviceType/delete_batch")
    public ReturnTextMsg deleteType(@RequestParam(value = "ids") String typeList){
        //如果成功，返回
        //插入成功if()
        if (typeList.contains(",")) {
            String[] split = typeList.split(",");
            for (int i = 0; i < split.length; i++) {
                deviceService.deleteByPrimaryKeyDeviceList(split[0]);
            }
        }else {
            //如果不是数组
            deviceService.deleteByPrimaryKeyDeviceList(typeList);
        }
        return ReturnTextMsg.createBySuccessMessage();
        //不成功返回ErrorMessage
    }
}
*/