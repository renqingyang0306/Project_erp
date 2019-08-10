package com.rqy.controller.quality;

import com.github.pagehelper.PageInfo;
import com.rqy.domain.ProcessCountCheck;
import com.rqy.service.quality.ProcessCountCheckService;
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
 * @date 2019/8/9 15:17
 */
@Controller
public class ProcessCountCheckController {

    @Autowired
    ProcessCountCheckService processCountCheckService;

    @RequestMapping("p_count_check/find")
    public String findProcessCountCheckJsp() {
        return "p_count_check_list";
    }

    @RequestMapping("p_count_check/list")
    @ResponseBody
    public PageBean findProcessCountCheckList(@RequestParam("page")int page, @RequestParam("rows")int rows) {
        List<ProcessCountCheck> processCountCheckList = processCountCheckService.findPageProcessCountCheck(page,rows);
        PageInfo<ProcessCountCheck> pageInfo = new PageInfo<>(processCountCheckList);
        long total = pageInfo.getTotal();
        PageBean pageResult = new PageBean(processCountCheckList,total);
        return pageResult;
    }

    @RequestMapping("p_count_check/search_pCountCheck_by_pCountCheckId")
    @ResponseBody
    public PageBean searchProcessCountCheckBypCountCheckId(@RequestParam("searchValue")String searchValue, @RequestParam("page")int page,@RequestParam("rows")int rows) {
        List<ProcessCountCheck> processCountChecks = processCountCheckService.searchPageProcessCountCheckByPCountCheckId(searchValue, page, rows);
        PageInfo<ProcessCountCheck> pageInfo = new PageInfo(processCountChecks);
        long total = pageInfo.getTotal();
        PageBean pageResult = new PageBean(processCountChecks,total);
        return pageResult;
    }

    @RequestMapping("pCountCheck/add_judge")
    @ResponseBody
    public String findProcessCountCheckAddData() {
        //我也不知道这是什么玩意儿，不返回就不显示页面，我也很绝望。。。。
        return " ";
    }
    @RequestMapping("p_count_check/add")
    public String findProcessCountCheckAddJsp() {
        //System.out.println("unqualify添加页面跳转");
        return "p_count_check_add";
    }

    @RequestMapping("p_count_check/insert")
    @ResponseBody
    public Map<String,String> insertProcessCountCheckResponse(ProcessCountCheck ProcessCountCheck) {
        //添加到数据库
        int insert = processCountCheckService.insertProcessCountCheck(ProcessCountCheck);
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

    @RequestMapping("pCountCheck/edit_judge")
    @ResponseBody
    public String findProcessCountCheckEditData() {
        //别问我，看add方法
        return " ";
    }

    @RequestMapping("p_count_check/edit")
    public String findProcessCountCheckEditJsp() {

        return "p_count_check_edit";
    }

    @RequestMapping("p_count_check/update_all")
    @ResponseBody
    public Map<String,String> updateProcessCountCheckResponse(ProcessCountCheck ProcessCountCheck) {
        //更新数据库信息
        int update = processCountCheckService.updateProcessCountCheckByPCountCheckId(ProcessCountCheck);
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

    @RequestMapping("pCountCheck/delete_judge")
    @ResponseBody
    public String findProcessCountCheckDeleteData() {
        //别问我，看edit方法
        return " ";
    }

    @RequestMapping("p_count_check/delete_batch")
    @ResponseBody
    public Map<String,String> deleteProcessCountCheckResponse(@Param("ids")String ids) {
        Map<String,String> map = new HashMap<>();
        String[] strings = ids.split(",");
        //删除数据库信息
        for (String s : strings) {
            int delete = processCountCheckService.deleteProcessCountCheck(s);
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
