package com.rqy.controller.quality;

import com.github.pagehelper.PageInfo;
import com.rqy.domain.UnqualifyApply;
import com.rqy.service.quality.UnqualityApplyService;
import com.rqy.utils.PageBean;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * @author 申涛涛
 * @date 2019/8/8 17:26
 */
@Controller
//@RequestMapping("unqualify")
public class UnqualityApplyController {

    Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    UnqualityApplyService unqualityApplyService;

    @RequestMapping("unqualify/find")
    public ModelAndView findUnqualifyJsp() {
        ModelAndView modelAndView = new ModelAndView();
        //List<UnqualifyApply> unqualifyApply = qualityMonitoringService.findUnqualifyApply();

        //modelAndView.addObject("unqualifyList",unqualifyApply);
        modelAndView.setViewName("unqualify_list");

        return modelAndView;
    }

    @RequestMapping("unqualify/list")
    @ResponseBody
    public PageBean queryPageUnqualifyList(@RequestParam("page")int page,@RequestParam("rows")int rows) {
        List<UnqualifyApply> unqualifyApply = unqualityApplyService.findPageUnqualifyApply(page,rows);
        PageInfo<UnqualifyApply> pageInfo = new PageInfo<>(unqualifyApply);
        long total = pageInfo.getTotal();
        PageBean pageResult = new PageBean(unqualifyApply,total);
        return pageResult;
    }

    @RequestMapping("unqualify/search_unqualify_by_unqualifyId")
    @ResponseBody
    public PageBean searchPageUnqualifyByUnqualifyId(@RequestParam("searchValue")String searchValue, @RequestParam("page")int page,@RequestParam("rows")int rows) {

        List<UnqualifyApply> unqualifyApply = unqualityApplyService.searchPageUnqualifyApplyByUnqualifyId(searchValue,page,rows);
        PageInfo<UnqualifyApply> pageInfo = new PageInfo(unqualifyApply);
        long total = pageInfo.getTotal();
        PageBean pageResult = new PageBean(unqualifyApply,total);
        return pageResult;
    }

    @RequestMapping("unqualify/search_unqualify_by_productName")
    @ResponseBody
    public PageBean searchPageUnqualifyByProductName(@RequestParam("searchValue")String searchValue, @RequestParam("page")int page,@RequestParam("rows")int rows) {
        List<UnqualifyApply> unqualifyApplies = unqualityApplyService.searchPageUnqualifyApplyByProductName(searchValue, page, rows);
        PageInfo<UnqualifyApply> pageInfo = new PageInfo(unqualifyApplies);
        long total = pageInfo.getTotal();
        PageBean pageResult = new PageBean(unqualifyApplies,total);
        logger.info(unqualifyApplies);
        return pageResult;

    }

    @RequestMapping("unqualify/add_judge")
    @ResponseBody
    public String findUnqualifyAddData() {
        //我也不知道这是什么玩意儿，不返回就不显示页面，我也很绝望。。。。
        return " ";
    }
    @RequestMapping("unqualify/add")
    public String findUnqualifyAddJsp() {
        //System.out.println("unqualify添加页面跳转");
        return "unqualify_add";
    }

    @RequestMapping("unqualify/insert")
    @ResponseBody
    public Map<String,String> findUnqualifyAddResponse(UnqualifyApply unqualifyApply) {
        //添加到数据库
        int insert = unqualityApplyService.insertUnqualifyApply(unqualifyApply);
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

    @RequestMapping("unqualify/edit_judge")
    @ResponseBody
    public String findUnqualifyEditData() {
        //别问我，看add方法
        return " ";
    }

    @RequestMapping("unqualify/edit")
    public String findUnqualifyEditJsp() {

        return "unqualify_edit";
    }

    @RequestMapping("unqualify/update_all")
    @ResponseBody
    public Map<String,String> findUnqualifyEditResponse(UnqualifyApply unqualifyApply) {
        //更新数据库
        int update = unqualityApplyService.updateUnqualifyApplyByUnqualifyApplyId(unqualifyApply);
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

    @RequestMapping("unqualify/delete_judge")
    @ResponseBody
    public String findUnqualifyDeleteData() {
        //别问我，看edit方法
        return " ";
    }

    @RequestMapping("unqualify/delete_batch")
    @ResponseBody
    public Map<String,String> findUnqualifyDeleteResponse(@Param("ids")String ids) {
        Map<String,String> map = new HashMap<>();
        String[] strings = ids.split(",");
        //删除数据库unqualify信息
        for (String s : strings) {
            int delete = unqualityApplyService.deleteUnqualifyApply(s);
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
