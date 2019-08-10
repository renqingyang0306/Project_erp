package com.rqy.controller.quality;

import com.github.pagehelper.PageInfo;
import com.rqy.domain.FinalCountCheck;
import com.rqy.domain.FinalCountCheckExample;
import com.rqy.service.quality.FinalCountCheckService;
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
 * @date 2019/8/9 14:47
 */
@Controller
public class FinalCountCheckController {

    @Autowired
    FinalCountCheckService finalCountCheckService;

    @RequestMapping("f_count_check/find")
    public String findf_count_checkJsp() {
        return "f_count_check_list";
    }

    @RequestMapping("f_count_check/list")
    @ResponseBody
    public PageBean findFinalCountCheckList(@RequestParam("page")int page, @RequestParam("rows")int rows) {
        List<FinalCountCheck> finalCountCheckList = finalCountCheckService.findPageFinalCountCheck(page, rows);
        PageInfo<FinalCountCheck> pageInfo = new PageInfo<>(finalCountCheckList);
        long total = pageInfo.getTotal();
        PageBean pageResult = new PageBean(finalCountCheckList,total);
        return pageResult;
    }

    @RequestMapping("f_count_check/search_fCountCheck_by_fCountCheckId")
    @ResponseBody
    public PageBean searchFinalCountCheckByFCountCheckId(@RequestParam("searchValue")String searchValue,@RequestParam("page")int page, @RequestParam("rows")int rows) {
        List<FinalCountCheck> finalCountChecks = finalCountCheckService.searchPageFinalCountCheckByFCountCheckId(searchValue, page, rows);
        PageInfo<FinalCountCheck> pageInfo = new PageInfo(finalCountChecks);
        long total = pageInfo.getTotal();
        PageBean pageResult = new PageBean(finalCountChecks,total);
        return pageResult;
    }

    @RequestMapping("f_count_check/search_fCountCheck_by_orderId")
    @ResponseBody
    public PageBean searchFinalCountCheckByOrderId(@RequestParam("searchValue")String searchValue,@RequestParam("page")int page, @RequestParam("rows")int rows) {
        List<FinalCountCheck> finalCountChecks = finalCountCheckService.searchPageFinalCountCheckByOrderId(searchValue, page, rows);
        PageInfo<FinalCountCheck> pageInfo = new PageInfo(finalCountChecks);
        long total = pageInfo.getTotal();
        PageBean pageResult = new PageBean(finalCountChecks,total);
        return pageResult;
    }

    @RequestMapping("fCountCheck/add_judge")
    @ResponseBody
    public String findFinalCountCheckAddData() {
        //我也不知道这是什么玩意儿，不返回就不显示页面，我也很绝望。。。。
        return " ";
    }
    @RequestMapping("f_count_check/add")
    public String findFinalCountCheckAddJsp() {
        //System.out.println("unqualify添加页面跳转");
        return "f_count_check_add";
    }

    @RequestMapping("f_count_check/insert")
    @ResponseBody
    public Map<String,String> insertFinalCountCheckResponse(FinalCountCheck finalCountCheck) {
        //添加到数据库
        int insert = finalCountCheckService.insertFinalCountCheck(finalCountCheck);
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

    @RequestMapping("fCountCheck/edit_judge")
    @ResponseBody
    public String findFinalCountCheckEditData() {
        //别问我，看add方法
        return " ";
    }

    @RequestMapping("f_count_check/edit")
    public String findFinalCountCheckEditJsp() {

        return "f_count_check_edit";
    }


    @RequestMapping("f_count_check/update_all")
    @ResponseBody
    public Map<String,String> updateFinalCountCheckResponse(FinalCountCheck FinalCountCheck) {
        //更新数据库信息
        int update = finalCountCheckService.updateFinalCountCheckByFCountCheckId(FinalCountCheck);
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

    @RequestMapping("fCountCheck/delete_judge")
    @ResponseBody
    public String findFinalCountCheckDeleteData() {
        //别问我，看edit方法
        return " ";
    }

    @RequestMapping("f_count_check/delete_batch")
    @ResponseBody
    public Map<String,String> deleteFinalCountCheckResponse(@Param("ids")String ids) {
        Map<String,String> map = new HashMap<>();
        String[] strings = ids.split(",");
        //删除数据库信息
        for (String s : strings) {
            int delete = finalCountCheckService.deleteFinalCountCheck(s);
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
