package com.rqy.service;

import com.rqy.domain.Technology;
import com.rqy.domain.TechnologyExample;
import com.rqy.domain.TechnologyPlan;
import com.rqy.domain.TechnologyPlanExample;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @auther XXX
 * @date 2019/8/8
 * @time 20:38
 */
public interface TechnologyPlanService {
    List<TechnologyPlan> selectByExample(TechnologyPlanExample technologyPlanExample);
}
