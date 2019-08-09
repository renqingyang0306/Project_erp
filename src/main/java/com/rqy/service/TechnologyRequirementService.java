package com.rqy.service;

import com.rqy.domain.Technology;
import com.rqy.domain.TechnologyExample;
import com.rqy.domain.TechnologyRequirement;
import com.rqy.domain.TechnologyRequirementExample;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @auther XXX
 * @date 2019/8/8
 * @time 21:07
 */
public interface TechnologyRequirementService {
    List<TechnologyRequirement> selectByExample(TechnologyRequirementExample technologyRequirementExample);
}
