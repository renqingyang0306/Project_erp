package com.rqy.controller.quality;

import com.rqy.domain.UnqualifyApply;
import com.rqy.service.quality.QualityMonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 申涛涛
 * @date 2019/8/8 17:26
 */
@Controller
//@RequestMapping("unqualify")
public class QualityMonitoringController {

    @Autowired
    QualityMonitoringService qualityMonitoringService;

    @RequestMapping("unqualify/find")
    public ModelAndView findUnqualifyJsp() {
        ModelAndView modelAndView = new ModelAndView();
        //List<UnqualifyApply> unqualifyApply = qualityMonitoringService.findUnqualifyApply();

        //modelAndView.addObject("unqualifyList",unqualifyApply);
        modelAndView.setViewName("unqualify_list");

        return modelAndView;
    }

    @RequestMapping("department/get_data")
    @ResponseBody
    public List<UnqualifyApply> queryAllUnqualifyList() {
        //ModelAndView modelAndView = new ModelAndView();
        List<UnqualifyApply> unqualifyApply = qualityMonitoringService.findUnqualifyApply();
        return unqualifyApply;

    }

    @RequestMapping("unqualify/list")
    @ResponseBody
    public List<UnqualifyApply> queryPageUnqualifyList() {
        //ModelAndView modelAndView = new ModelAndView();

        List<UnqualifyApply> unqualifyApply = qualityMonitoringService.findUnqualifyApply();

        return unqualifyApply;

    }
}
