package com.rqy.controller;

import com.rqy.domain.*;
import com.rqy.service.TechnologyPlanService;
import com.rqy.service.TechnologyRequirementService;
import com.rqy.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @auther XXX
 * @date 2019/8/8
 * @time 15:59
 */
@Controller
public class TechnologyRequirementController {

    @Autowired
    TechnologyRequirementService technologyRequirementService;

    @RequestMapping("technologyRequirement/find")
    public String technologyRequirementFind() {
        return "technologyRequirement_list";
    }

    @RequestMapping("technologyRequirement/list")
    @ResponseBody
    public List<TechnologyRequirement> technologyRequirementsFindList() {
        TechnologyRequirementExample technologyRequirementExample
                = new TechnologyRequirementExample();

        return technologyRequirementService.selectByExample(technologyRequirementExample);
    }
}
