package com.rqy.service.ServiceImpl;

import com.rqy.domain.TechnologyRequirement;
import com.rqy.domain.TechnologyRequirementExample;
import com.rqy.mapper.TechnologyMapper;
import com.rqy.mapper.TechnologyPlanMapper;
import com.rqy.mapper.TechnologyRequirementMapper;
import com.rqy.service.TechnologyRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @auther XXX
 * @date 2019/8/8
 * @time 21:10
 */
@Service
public class TechnologyRequirementServiceImpl implements TechnologyRequirementService {

    @Autowired
    TechnologyRequirementMapper technologyRequirementMapper;

    @Override
    public List<TechnologyRequirement> selectByExample(TechnologyRequirementExample technologyRequirementExample) {
        return technologyRequirementMapper.selectByExample(technologyRequirementExample);
    }
}
