package com.rqy.controller.device;



import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rqy.domain.*;
import com.rqy.service.device.DeviceService;
import com.rqy.service.device.DeviceTypeService;
import com.rqy.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
    
   @RequestMapping("/deviceList/search_device_by_deviceName")
    @ResponseBody
    public PageBean searchNamelistName(@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows,
                                       @RequestParam(value = "searchValue") String searchValue){

        PageHelper.startPage(page, rows);
        searchValue = "%"+searchValue+"%";
        List<Device> devices = deviceService.selectByLikeName(searchValue);

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
    public RespondMsg update(@Valid Device device, BindingResult bindingResult) {
        //插入用领域模型
          if(!bindingResult.hasErrors()){
        int i = deviceService.updateByPrimaryKey(device);
        if (i==1){
            return RespondMsg.createSusscess();
        }}
        return  RespondMsg.createFail();
        }
//增 
    @ResponseBody
    @RequestMapping("deviceList/update_all")
    public RespondMsg updateall(@Valid Device device, BindingResult bindingResult) {
        //插入用领域模型
        if(!bindingResult.hasErrors()){
        int i = deviceService.updateByPrimaryKey(device);
        if (i==1){
            return RespondMsg.createSusscess();
        }}
        return  RespondMsg.createFail();
    }
     @ResponseBody
    @RequestMapping("deviceList/update_note")
    public RespondMsg updatenote(Device device) {
        //插入用领域模型
        int i = deviceService.updateByPrimaryKey(device);
        if (i==1){
            return RespondMsg.createSusscess();
        }
        return  RespondMsg.createFail();
    }
    @ResponseBody
    @RequestMapping("deviceList/insert")
    public RespondMsg insert(@Valid Device device, BindingResult bindingResult) {
        //插入用领域模型
         if(!bindingResult.hasErrors()){
        int i = deviceService.insert(device);
        if (i==1){
            return RespondMsg.createSusscess();
        }}
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




