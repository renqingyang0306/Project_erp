package com.rqy.service.ServiceImpl;

import com.rqy.domain.TechnologyPlan;
import com.rqy.domain.TechnologyPlanExample;
import com.rqy.mapper.TechnologyPlanMapper;
import com.rqy.service.TechnologyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @auther XXX
 * @date 2019/8/8
 * @time 20:40
 */
@Service
public class TechnologyPlanServiceImpl implements TechnologyPlanService {
    @Autowired
    TechnologyPlanMapper technologyPlanMapper;
    @Override
    public List<TechnologyPlan> selectByExample(TechnologyPlanExample technologyPlanExample) {

        return technologyPlanMapper.selectByExample(technologyPlanExample);
    }
}
