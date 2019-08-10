package com.rqy.controller.quality;

import com.github.pagehelper.PageInfo;
import com.rqy.domain.ProcessMeasureCheck;
import com.rqy.service.quality.ProcessMeasureCheckService;
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
 * @date 2019/8/9 15:10
 */
@Controller
public class ProcessMeasureCheckController {
    @Autowired
    ProcessMeasureCheckService processMeasureCheckService;

    @RequestMapping("p_measure_check/find")
    public String findProcessMeasureCheckJsp() {
        return "p_measure_check_list";
    }

    @RequestMapping("p_measure_check/list")
    @ResponseBody
    public PageBean findProcessMeasureCheckList(@RequestParam("page")int page, @RequestParam("rows")int rows) {
        List<ProcessMeasureCheck> processMeasureCheckList = processMeasureCheckService.findPageProcessMeasureCheck(page,rows);
        PageInfo<ProcessMeasureCheck> pageInfo = new PageInfo<>(processMeasureCheckList);
        long total = pageInfo.getTotal();
        PageBean pageResult = new PageBean(processMeasureCheckList,total);
        return pageResult;
    }

    @RequestMapping("p_measure_check/search_pMeasureCheck_by_pMeasureCheckId")
    @ResponseBody
    public PageBean searchProcessMeasureCheckBypMeasureCheckId(@RequestParam("searchValue")String searchValue, @RequestParam("page")int page,@RequestParam("rows")int rows) {

        List<ProcessMeasureCheck> processMeasureChecks = processMeasureCheckService.searchPageProcessMeasureCheckByPMeansureCheckId(searchValue, page, rows);
        PageInfo<ProcessMeasureCheck> pageInfo = new PageInfo(processMeasureChecks);
        long total = pageInfo.getTotal();
        PageBean pageResult = new PageBean(processMeasureChecks,total);
        return pageResult;
    }

    @RequestMapping("pMeasureCheck/add_judge")
    @ResponseBody
    public String findProcessMeasureCheckAddData() {
        //我也不知道这是什么玩意儿，不返回就不显示页面，我也很绝望。。。。
        return " ";
    }
    @RequestMapping("p_measure_check/add")
    public String findProcessMeasureCheckAddJsp() {
        //System.out.println("unqualify添加页面跳转");
        return "p_measure_check_add";
    }

    @RequestMapping("p_measure_check/insert")
    @ResponseBody
    public Map<String,String> insertProcessMeasureCheckResponse(ProcessMeasureCheck processMeasureCheck) {
        //添加到数据库
        int insert = processMeasureCheckService.insertProcessMeasureCheck(processMeasureCheck);
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

    @RequestMapping("pMeasureCheck/edit_judge")
    @ResponseBody
    public String findProcessMeasureCheckEditData() {
        //别问我，看add方法
        return " ";
    }

    @RequestMapping("p_measure_check/edit")
    public String findProcessMeasureCheckEditJsp() {

        return "p_measure_check_edit";
    }


    @RequestMapping("p_measure_check/update_all")
    @ResponseBody
    public Map<String,String> updateProcessMeasureCheckResponse(ProcessMeasureCheck processMeasureCheck) {
        //更新数据库信息
        int update = processMeasureCheckService.updateProcessMeasureCheckByPMeasureCheckId(processMeasureCheck);
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

    @RequestMapping("pMeasureCheck/delete_judge")
    @ResponseBody
    public String findProcessMeasureCheckDeleteData() {
        //别问我，看edit方法
        return " ";
    }

    @RequestMapping("p_measure_check/delete_batch")
    @ResponseBody
    public Map<String,String> deleteProcessMeasureCheckResponse(@Param("ids")String ids) {
        Map<String,String> map = new HashMap<>();
        String[] strings = ids.split(",");
        //删除数据库信息
        for (String s : strings) {
            int delete = processMeasureCheckService.deleteProcessMeasureCheck(s);
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
