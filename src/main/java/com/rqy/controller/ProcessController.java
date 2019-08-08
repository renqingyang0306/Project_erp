package com.rqy.controller;

import com.rqy.domain.Process;
import com.rqy.domain.ProcessExample;
import com.rqy.domain.TechnologyPlan;
import com.rqy.domain.TechnologyPlanExample;
import com.rqy.service.ProcessService;
import com.rqy.service.TechnologyPlanService;
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
 * @time 21:16
 */
@Controller
public class ProcessController {
    @Autowired
    ProcessService processService;

    @RequestMapping("process/find")
    public String processFind() {
        return "process_list";
    }

    @RequestMapping("process/list")
    @ResponseBody
    public List<Process> processFindList() {
        ProcessExample processExample = new ProcessExample();
        return processService.selectByExample(processExample);
    }
}
