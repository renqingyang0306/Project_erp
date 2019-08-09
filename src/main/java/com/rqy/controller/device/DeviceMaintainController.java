package com.rqy.controller.device;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rqy.domain.DeviceMaintain;
import com.rqy.domain.DeviceMaintainExample;
import com.rqy.service.device.DeviceMaintainService;
import com.rqy.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class DeviceMaintainController {
    @Autowired
    DeviceMaintainService deviceMaintainService;


    @RequestMapping("/deviceMaintain/add_judge")
    public String findadd1(){
        return "deviceMaintain_add";
    }
    @RequestMapping("/deviceMaintain/add")
    public String findadd(){
        return "deviceMaintain_add";
    }

    @RequestMapping("deviceMaintain/edit_judge")
    public String findadd4(){
        return "deviceMaintain_edit";
    }

    @RequestMapping("/deviceMaintain/edit")
    public String findadd3(){
        return "deviceMaintain_edit";}

    @ResponseBody
    @RequestMapping("deviceMaintain/delete_judge")
    public String findadd5(){
        return "";
    }


    @RequestMapping("/device/deviceMaintain")
    public String find(){
        return "deviceMaintain";
    }
    @RequestMapping("/deviceMaintain/list")
    @ResponseBody
    public PageBean list(@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows){
        DeviceMaintainExample deviceExample = new DeviceMaintainExample();
        PageHelper.startPage(page, rows);
        List<DeviceMaintain> devices = deviceMaintainService.selectByExample(deviceExample);

        PageInfo<DeviceMaintain> pageInfo = new PageInfo<>(devices);

        long total = pageInfo.getTotal();

        PageBean pageResult = new PageBean();

        pageResult.setTotal(total);
        pageResult.setRows(devices);
        return pageResult;
    }

    //删
    @ResponseBody
    @RequestMapping("deviceMaintain/delete_batch")
    public RespondMsg delete(String ids) {

        if (ids.contains(",")) {
            String[] split = ids.split(",");
            for (int i = 0; i < split.length; i++) {
                deviceMaintainService.deleteByPrimaryKey(split[i]);
            }
            int result = 1;
            return RespondMsg.createSusscess();
        } else {
            //如果不是数组
            deviceMaintainService.deleteByPrimaryKey(ids);
            int result1 = deviceMaintainService.deleteByPrimaryKey(ids);
            return RespondMsg.createSusscess();
        }
    }
    //改
    @ResponseBody
    @RequestMapping("deviceMaintain/update")
    public RespondMsg update(DeviceMaintain device) {
        //插入用领域模型
        int i = deviceMaintainService.updateByPrimaryKey(device);
        if (i==1){
            return RespondMsg.createSusscess();
        }
        return  RespondMsg.createFail();
    }
    //增
    @ResponseBody
    @RequestMapping("deviceMaintain/insert")
    public RespondMsg insert(DeviceMaintain device) {
        //插入用领域模型
        int i = deviceMaintainService.insert(device);
        if (i==1){
            return RespondMsg.createSusscess();
        }
        return  RespondMsg.createFail();
    }

    @RequestMapping("deviceMaintain/search_deviceMaintain_by_deviceMaintainId")
    @ResponseBody
    public PageBean searchIdlists(@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows,
                                  @RequestParam(value = "searchValue") String searchValue){
        DeviceMaintainExample deviceExample = new DeviceMaintainExample();
        DeviceMaintainExample.Criteria criteria = deviceExample.createCriteria();
        criteria.andDeviceMaintainIdLike("%"+searchValue+"%");
        PageHelper.startPage(page, rows);
        List<DeviceMaintain> devices = deviceMaintainService.selectByExample(deviceExample);
        deviceExample.clear();
        PageInfo<DeviceMaintain> pageInfo = new PageInfo<>(devices);
        long total = pageInfo.getTotal();

        PageBean pageResult = new PageBean();

        pageResult.setTotal(total);
        pageResult.setRows(devices);
        return pageResult;
    }
    @RequestMapping("deviceMaintain/search_deviceMaintain_by_deviceFaultId")
    @ResponseBody
    public PageBean searchIdlistsssss(@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows,
                                  @RequestParam(value = "searchValue") String searchValue){
        DeviceMaintainExample deviceExample = new DeviceMaintainExample();
        DeviceMaintainExample.Criteria criteria = deviceExample.createCriteria();
        criteria.andDeviceFaultIdLike("%"+searchValue+"%");
        PageHelper.startPage(page, rows);
        List<DeviceMaintain> devices = deviceMaintainService.selectByExample(deviceExample);
        deviceExample.clear();
        PageInfo<DeviceMaintain> pageInfo = new PageInfo<>(devices);
        long total = pageInfo.getTotal();

        PageBean pageResult = new PageBean();

        pageResult.setTotal(total);
        pageResult.setRows(devices);
        return pageResult;
    }
}
