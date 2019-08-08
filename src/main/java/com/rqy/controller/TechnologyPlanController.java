package com.rqy.controller;

import com.rqy.domain.Technology;
import com.rqy.domain.TechnologyExample;
import com.rqy.domain.TechnologyPlan;
import com.rqy.domain.TechnologyPlanExample;
import com.rqy.service.TechnologyPlanService;
import com.rqy.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TechnologyPlanController {

    @Autowired
    TechnologyPlanService technologyPlanService;

    @RequestMapping("technologyPlan/find")
    public String technologyPlanFind() {
        return "technologyPlan_list";
    }

    @RequestMapping("technologyPlan/list")
    @ResponseBody
    public List<TechnologyPlan> technologyPlanFindList() {
        TechnologyPlanExample technologyPlanExample = new TechnologyPlanExample();
List<TechnologyPlan> technologies =
                technologyPlanService.selectByExample(technologyPlanExample);

        return technologyPlanService.selectByExample(technologyPlanExample);
    }
}
