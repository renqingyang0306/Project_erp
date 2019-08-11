package com.rqy.controller.device;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rqy.domain.DeviceFault;
import com.rqy.domain.DeviceFaultExample;
import com.rqy.service.device.DeviceFaultService;
import com.rqy.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class DeviceFaultController {
    @Autowired
    DeviceFaultService deviceFaultService;

    @RequestMapping("/deviceFault/add_judge")
    public String findadd1(){
        return "deviceFault_add";
    }
    @RequestMapping("/deviceFault/add")
    public String findadd(){
        return "deviceFault_add";
    }

    @RequestMapping("deviceFault/edit_judge")
    public String findadd4(){
        return "deviceFault_edit";
    }

    @RequestMapping("/deviceFault/edit")
    public String findadd3(){
        return "deviceFault_edit";}

    @ResponseBody
    @RequestMapping("deviceFault/delete_judge")
    public String findadd5(){
        return "";
    }
    @RequestMapping("/device/deviceFault")
    public String find(){
        return "deviceFault";
    }
    @RequestMapping("/deviceFault/list")
    @ResponseBody
    public PageBean list(@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows){
        DeviceFaultExample deviceExample = new DeviceFaultExample();
        PageHelper.startPage(page, rows);
        List<DeviceFault> devices = deviceFaultService.selectByExample(deviceExample);

        PageInfo<DeviceFault> pageInfo = new PageInfo<>(devices);

        long total = pageInfo.getTotal();

        PageBean pageResult = new PageBean();

        pageResult.setTotal(total);
        pageResult.setRows(devices);
        return pageResult;
    }

    //删
    @ResponseBody
    @RequestMapping("deviceFault/delete_batch")
    public RespondMsg delete(String ids) {

        if (ids.contains(",")) {
            String[] split = ids.split(",");
            for (int i = 0; i < split.length; i++) {
                deviceFaultService.deleteByPrimaryKey(split[i]);
            }
            int result = 1;
            return RespondMsg.createSusscess();
        } else {
            //如果不是数组
            deviceFaultService.deleteByPrimaryKey(ids);
            int result1 = deviceFaultService.deleteByPrimaryKey(ids);
            return RespondMsg.createSusscess();
        }
    }
    //改
    @ResponseBody
    @RequestMapping("deviceFault/update")
    public RespondMsg update(DeviceFault device) {
        //插入用领域模型
        int i = deviceFaultService.updateByPrimaryKey(device);
        if (i==1){
            return RespondMsg.createSusscess();
        }
        return  RespondMsg.createFail();
    }
     @ResponseBody
    @RequestMapping("deviceFault/update_all")
    public RespondMsg updateall(DeviceFault device) {
        //插入用领域模型
        int i = deviceFaultService.updateByPrimaryKey(device);
        if (i==1){
            return RespondMsg.createSusscess();
        }
        return  RespondMsg.createFail();
    }
    //增
    @ResponseBody
    @RequestMapping("deviceFault/insert")
    public RespondMsg insert(DeviceFault device) {
        //插入用领域模型
        int i = deviceFaultService.insert(device);
        if (i!=0){
            return RespondMsg.createSusscess();
        }
        return  RespondMsg.createFail();
    }

    @ResponseBody
    @RequestMapping("deviceFault/get_data")
    public List<DeviceFault> getData() {
        //插入用领域模型
        DeviceFaultExample deviceExample = new DeviceFaultExample();
        List<DeviceFault> devices = deviceFaultService.selectByExample(deviceExample);
        return  devices;
    }
    @ResponseBody
    @RequestMapping("deviceFault/get/{id}")
    public DeviceFault searchName(@PathVariable("id") Integer id){
        DeviceFaultExample deviceExample = new DeviceFaultExample();
        DeviceFaultExample.Criteria criteria = deviceExample.createCriteria();
        criteria.andDeviceFaultIdEqualTo(id);
        List<DeviceFault> devices = deviceFaultService.selectByExample(deviceExample);
        DeviceFault device = new DeviceFault();
        device =devices.get(0);
        return device;
    }

    @RequestMapping("deviceFault/search_deviceFault_by_deviceFaultId")
    @ResponseBody
    public PageBean searchIdlists(@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows,
                                  @RequestParam(value = "searchValue") String searchValue){
        DeviceFaultExample deviceExample = new DeviceFaultExample();
        DeviceFaultExample.Criteria criteria = deviceExample.createCriteria();
        criteria.andDeviceFaultIdLike("%"+searchValue+"%");
        PageHelper.startPage(page, rows);
        List<DeviceFault> devices = deviceFaultService.selectByExample(deviceExample);
        deviceExample.clear();
        PageInfo<DeviceFault> pageInfo = new PageInfo<>(devices);
        long total = pageInfo.getTotal();

        PageBean pageResult = new PageBean();

        pageResult.setTotal(total);
        pageResult.setRows(devices);
        return pageResult;
    }

   @RequestMapping("deviceFault/search_deviceFault_by_deviceName")
    @ResponseBody
    public PageBean searchIdlistsss(@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows,
                                  @RequestParam(value = "searchValue") String searchValue){
       PageHelper.startPage(page, rows);
       searchValue = "%"+searchValue+"%";
       List<DeviceFault> devices = deviceFaultService.selectByLike(searchValue);

       PageInfo<DeviceFault> pageInfo = new PageInfo<>(devices);

       long total = pageInfo.getTotal();

       PageBean pageResult = new PageBean();

       pageResult.setTotal(total);
       pageResult.setRows(devices);
       return pageResult;
    }
}
