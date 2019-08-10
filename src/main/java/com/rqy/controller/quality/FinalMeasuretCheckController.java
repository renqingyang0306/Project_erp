package com.rqy.controller.quality;

import com.github.pagehelper.PageInfo;
import com.rqy.domain.FinalMeasuretCheck;
import com.rqy.service.quality.FinalMeasuretCheckService;
import com.rqy.utils.PageBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 申涛涛
 * @date 2019/8/8 21:54
 * 成品质量质检
 */
@Controller
public class FinalMeasuretCheckController {

    @Autowired
    FinalMeasuretCheckService finalMeasuretCheckService;

    @RequestMapping("measure/find")
    public String findMeasureJsp() {
        return "measurement_list";
    }

    @RequestMapping("measure/list")
    @ResponseBody
    public PageBean findFinalMeasuretCheckList(@RequestParam("page")int page, @RequestParam("rows")int rows) {
        List<FinalMeasuretCheck> finalMeasuretCheck = finalMeasuretCheckService.findPageFinalMeasuretCheck(page, rows);
        PageInfo<FinalMeasuretCheck> pageInfo = new PageInfo<>(finalMeasuretCheck);
        long total = pageInfo.getTotal();
        PageBean pageResult = new PageBean(finalMeasuretCheck,total);
        return pageResult;
    }

    @RequestMapping("measure/search_fMeasureCheck_by_fMeasureCheckId")
    @ResponseBody
    public PageBean searchFinalMeasuretCheckByFMeasureCheckId(@RequestParam("searchValue")String searchValue,@RequestParam("page")int page, @RequestParam("rows")int rows) {
        List<FinalMeasuretCheck> finalMeasuretChecks = finalMeasuretCheckService.searchPageFinalMeasuretCheckByFMeasureCheckId(searchValue, page, rows);
        PageInfo<FinalMeasuretCheck> pageInfo = new PageInfo(finalMeasuretChecks);
        long total = pageInfo.getTotal();
        PageBean pageResult = new PageBean(finalMeasuretChecks,total);
        return pageResult;
    }

    @RequestMapping("measure/search_fMeasureCheck_by_orderId")
    @ResponseBody
    public PageBean searchFinalMeasuretCheckByOrderId(@RequestParam("searchValue")String searchValue,@RequestParam("page")int page, @RequestParam("rows")int rows) {
        List<FinalMeasuretCheck> finalMeasuretChecks = finalMeasuretCheckService.searchPageFinalMeasuretCheckByOrderId(searchValue, page, rows);
        PageInfo<FinalMeasuretCheck> pageInfo = new PageInfo(finalMeasuretChecks);
        long total = pageInfo.getTotal();
        PageBean pageResult = new PageBean(finalMeasuretChecks,total);
        return pageResult;
    }


    @RequestMapping("fMeasureCheck/add_judge")
    @ResponseBody
    public String findFinalMeasuretCheckAddData() {
        //我也不知道这是什么玩意儿，不返回就不显示页面，我也很绝望。。。。
        return " ";
    }
    @RequestMapping("measure/add")
    public String findFinalMeasuretCheckAddJsp() {
        //System.out.println("unqualify添加页面跳转");
        return "measurement_add";
    }

    @RequestMapping("measure/insert")
    @ResponseBody
    public Map<String,String> insertFinalMeasuretCheckResponse(FinalMeasuretCheck FinalMeasuretCheck) {
        //添加到数据库
        int insert = finalMeasuretCheckService.insertFinalMeasuretCheck(FinalMeasuretCheck);
        Map<String,String> map = new HashMap<>();
        if (insert == 0) {
            map.put("status","302");
            map.put("msg","fail");
            map.put("data","添加失败");
            return map;
        }

        //响应消息
        map.put("status","200");
        map.put("msg","OK");
        map.put("data","null");
        return map;
    }

    @RequestMapping("fMeasureCheck/edit_judge")
    @ResponseBody
    public String findFinalMeasuretCheckEditData() {
        //别问我，看add方法
        return " ";
    }

    @RequestMapping("measure/edit")
    public String findFinalMeasuretCheckEditJsp() {

        return "measurement_edit";
    }


    @RequestMapping("measure/update_all")
    @ResponseBody
    public Map<String,String> updateFinalMeasuretCheckResponse(FinalMeasuretCheck FinalMeasuretCheck) {
        //更新数据库信息
        int update = finalMeasuretCheckService.updateFinalMeasuretCheckByFMeasureCheckId(FinalMeasuretCheck);
        Map<String,String> map = new HashMap<>();
        if (update == 0) {

            map.put("status","302");
            map.put("msg","fail");
            map.put("data","添加失败");
            return map;
        }

        //响应消息
        map.put("status","200");
        map.put("msg","OK");
        map.put("data","null");
        return map;
    }

    @RequestMapping("fMeasureCheck/delete_judge")
    @ResponseBody
    public String findFinalMeasuretCheckDeleteData() {
        //别问我，看edit方法
        return " ";
    }

    @RequestMapping("measure/delete_batch")
    @ResponseBody
    public Map<String,String> deleteFinalMeasuretCheckResponse(@Param("ids")String ids) {
        Map<String,String> map = new HashMap<>();
        String[] strings = ids.split(",");
        //删除数据库信息
        for (String s : strings) {
            int delete = finalMeasuretCheckService.deleteFinalMeasuretCheck(s);
            if (delete == 0){
                //响应消息
                map.put("status","302");
                map.put("msg","fail");
                map.put("data","数据删除失败");
                return map;
            }
        }

        //响应消息
        map.put("status","200");
        map.put("msg","OK");
        map.put("data","null");
        return map;
    }
}
