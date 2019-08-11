package com.rqy.controller.device;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rqy.domain.DeviceType;
import com.rqy.domain.DeviceTypeExample;
import com.rqy.service.device.DeviceTypeService;
import com.rqy.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class DeviceTypeController {

   @Autowired
    DeviceTypeService deviceTypeService;



    @RequestMapping("/deviceType/add_judge")
    public String findadd1(){
        return "deviceType_add";
    }
    @RequestMapping("/deviceType/add")
    public String findadd(){
        return "deviceType_add";
    }

    @RequestMapping("deviceType/edit_judge")
    public String findadd4(){
        return "deviceType_edit";
    }

    @RequestMapping("/deviceType/edit")
    public String findadd3(){
        return "deviceType_edit";}

    @ResponseBody
    @RequestMapping("deviceType/delete_judge")
    public String findadd5(){
        return "";
    }

    @RequestMapping("/device/deviceType")
    public String findType(){
        return "deviceType";
    }
    @RequestMapping("/deviceType/list")
    @ResponseBody
    public PageBean list1(@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows){
        DeviceTypeExample deviceExample = new DeviceTypeExample();
        List<DeviceType> devices = deviceTypeService.selectByExample(deviceExample);
        PageInfo<DeviceType> pageInfo = new PageInfo<>(devices);

        long total = pageInfo.getTotal();

        PageBean pageResult = new PageBean();

        pageResult.setTotal(total);
        pageResult.setRows(devices);
        return pageResult;
    }


    //删
    @ResponseBody
    @RequestMapping("deviceType/delete_batch")
    public RespondMsg delete(String ids) {

        if (ids.contains(",")) {
            String[] split = ids.split(",");
            for (int i = 0; i < split.length; i++) {
                deviceTypeService.deleteByPrimaryKey(split[i]);
            }
            int result = 1;
            return RespondMsg.createSusscess();
        } else {
            //如果不是数组
            deviceTypeService.deleteByPrimaryKey(ids);
            int result1 = deviceTypeService.deleteByPrimaryKey(ids);
            return RespondMsg.createSusscess();
        }
    }
    //改
    @ResponseBody
    @RequestMapping("deviceType/update")
    public RespondMsg update(DeviceType device) {
        //插入用领域模型
        int i = deviceTypeService.updateByPrimaryKey(device);
        if (i==1){
            return RespondMsg.createSusscess();
        }
        return  RespondMsg.createFail();
    }
   
   @ResponseBody
    @RequestMapping("deviceType/update_all")
    public RespondMsg updateall(DeviceType device) {
        //插入用领域模型
        int i = deviceTypeService.updateByPrimaryKey(device);
        if (i==1){
            return RespondMsg.createSusscess();
        }
        return  RespondMsg.createFail();
    }
    //增
    @ResponseBody
    @RequestMapping("deviceType/insert")
    public RespondMsg insert(DeviceType device) {
        //插入用领域模型
        int i = deviceTypeService.insert(device);
        if (i==1){
            return RespondMsg.createSusscess();
        }
        return  RespondMsg.createFail();
    }
    @ResponseBody
    @RequestMapping("deviceType/get_data")
    public List<DeviceType> searchNamelist(){
        DeviceTypeExample deviceExample = new DeviceTypeExample();
        DeviceTypeExample.Criteria criteria = deviceExample.createCriteria();
        List<DeviceType> devices = deviceTypeService.selectByExample(deviceExample);
        return devices;
    }
    @ResponseBody
    @RequestMapping("deviceType/get/{id}")
    public DeviceType searchName(@PathVariable("id") Integer id){
        DeviceTypeExample deviceExample = new DeviceTypeExample();
        DeviceTypeExample.Criteria criteria = deviceExample.createCriteria();
        criteria.andDeviceTypeIdEqualTo(id);
        List<DeviceType> devices = deviceTypeService.selectByExample(deviceExample);
        DeviceType device = new DeviceType();
        device =devices.get(0);
        return device;
    }

    @RequestMapping("deviceType/search_deviceType_by_deviceTypeId")
    @ResponseBody
    public PageBean searchIdlist(@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows,
                                 @RequestParam(value = "searchValue") int searchValue){
        DeviceTypeExample deviceExample = new DeviceTypeExample();
        DeviceTypeExample.Criteria criteria = deviceExample.createCriteria();
        criteria.andDeviceTypeIdLike("%"+searchValue+"%");
        PageHelper.startPage(page, rows);
        List<DeviceType> devices = deviceTypeService.selectByExample(deviceExample);
        deviceExample.clear();
        PageInfo<DeviceType> pageInfo = new PageInfo<>(devices);
        long total = pageInfo.getTotal();

        PageBean pageResult = new PageBean();

        pageResult.setTotal(total);
        pageResult.setRows(devices);
        return pageResult;
    }
    @RequestMapping("deviceType/search_deviceType_by_deviceTypeName")
    @ResponseBody
    public PageBean searchIdlists(@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows,
                                  @RequestParam(value = "searchValue") String searchValue){
        DeviceTypeExample deviceExample = new DeviceTypeExample();
        DeviceTypeExample.Criteria criteria = deviceExample.createCriteria();
        criteria.andDeviceTypeNameLike("%"+searchValue+"%");
        PageHelper.startPage(page, rows);
        List<DeviceType> devices = deviceTypeService.selectByExample(deviceExample);
        deviceExample.clear();
        PageInfo<DeviceType> pageInfo = new PageInfo<>(devices);
        long total = pageInfo.getTotal();

        PageBean pageResult = new PageBean();

        pageResult.setTotal(total);
        pageResult.setRows(devices);
        return pageResult;
    }
}
