package com.rqy.service;

import com.rqy.domain.Process;
import com.rqy.domain.ProcessExample;
import com.rqy.domain.TechnologyPlan;
import com.rqy.domain.TechnologyPlanExample;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @auther XXX
 * @date 2019/8/8
 * @time 21:17
 */
public interface ProcessService {
    List<Process> selectByExample(ProcessExample processExample);
}
