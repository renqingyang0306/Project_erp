package com.rqy.controller.device;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rqy.domain.DeviceCheck;
import com.rqy.domain.DeviceCheckExample;
import com.rqy.service.device.DeviceCheckService;
import com.rqy.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class DeviceCheckController {
    @Autowired
    DeviceCheckService deviceCheckService;
    @RequestMapping("/device/deviceCheck")
    public String find22(){
        return "deviceCheck";
    }
    @RequestMapping("/deviceCheck/add_judge")
    public String findadd1(){
        return "deviceCheck_add";
    }
    @RequestMapping("/deviceCheck/add")
    public String findadd(){
        return "deviceCheck_add";
    }

    @RequestMapping("deviceCheck/edit_judge")
    public String findadd4(){
        return "deviceCheck_edit";
    }

    @RequestMapping("/deviceCheck/edit")
    public String findadd3(){
        return "deviceCheck_edit";}

    @ResponseBody
    @RequestMapping("deviceCheck/delete_judge")
    public String findadd5(){
        return "";
    }
    @RequestMapping("/deviceCheck/list")
    @ResponseBody
    public PageBean list(@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows){
        DeviceCheckExample deviceExample = new DeviceCheckExample();
        PageHelper.startPage(page, rows);

        List<DeviceCheck> devices = deviceCheckService.selectByExample(deviceExample);
        PageInfo<DeviceCheck> pageInfo = new PageInfo<>(devices);

        long total = pageInfo.getTotal();

        //Page类是为了返回给前端封装总条数和具体列表
        PageBean pageResult = new PageBean();

        pageResult.setTotal(total);
        pageResult.setRows(devices);
        return pageResult;
    }


    //删
    @ResponseBody
    @RequestMapping("deviceCheck/delete_batch")
    public RespondMsg delete(String ids) {

        if (ids.contains(",")) {
            String[] split = ids.split(",");
            for (int i = 0; i < split.length; i++) {
                deviceCheckService.deleteByPrimaryKey(split[i]);
            }
            int result = 1;
            return RespondMsg.createSusscess();
        } else {
            //如果不是数组
            deviceCheckService.deleteByPrimaryKey(ids);
            int result1 = deviceCheckService.deleteByPrimaryKey(ids);
            return RespondMsg.createSusscess();
        }
    }
    //改
    @ResponseBody
    @RequestMapping("deviceCheck/update")
    public RespondMsg update(DeviceCheck device) {
        //插入用领域模型
        int i = deviceCheckService.updateByPrimaryKey(device);
        if (i==1){
            return RespondMsg.createSusscess();
        }
        return  RespondMsg.createFail();
    }
    //增
    @ResponseBody
    @RequestMapping("deviceCheck/insert")
    public RespondMsg insert(DeviceCheck device) {
        //插入用领域模型
        int i = deviceCheckService.insert(device);
        if (i==1){
            return RespondMsg.createSusscess();
        }
        return  RespondMsg.createFail();
    }


    @RequestMapping("deviceCheck/search_deviceCheck_by_deviceName")
    @ResponseBody
    public PageBean searchIdlists(@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows,
                                  @RequestParam(value = "searchValue") String searchValue){
        PageHelper.startPage(page, rows);
        searchValue = "%"+searchValue+"%";
        List<DeviceCheck> devices = deviceCheckService.selectByLike(searchValue);

        PageInfo<DeviceCheck> pageInfo = new PageInfo<>(devices);

        long total = pageInfo.getTotal();

        PageBean pageResult = new PageBean();

        pageResult.setTotal(total);
        pageResult.setRows(devices);
        return pageResult;
    }




    @RequestMapping("deviceCheck/search_deviceCheck_by_deviceCheckId")
    @ResponseBody
    public PageBean searchIdlists(@RequestParam(value = "page") int page, @RequestParam(value = "rows") int rows,
                                  @RequestParam(value = "searchValue") int searchValue){
        DeviceCheckExample deviceExample = new DeviceCheckExample();
        DeviceCheckExample.Criteria criteria = deviceExample.createCriteria();
        criteria.andDeviceCheckIdLike("%"+searchValue+"%");
        PageHelper.startPage(page, rows);
        List<DeviceCheck> devices = deviceCheckService.selectByExample(deviceExample);
        deviceExample.clear();
        PageInfo<DeviceCheck> pageInfo = new PageInfo<>(devices);
        long total = pageInfo.getTotal();

        PageBean pageResult = new PageBean();

        pageResult.setTotal(total);
        pageResult.setRows(devices);
        return pageResult;
    }

}
