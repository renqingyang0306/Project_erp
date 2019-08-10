package com.rqy.service.technology;

import com.rqy.domain.Technology;
import com.rqy.domain.TechnologyPlan;
import com.rqy.domain.TechnologyPlanExample;
import com.rqy.mapper.TechnologyPlanMapper;
import com.rqy.service.technology.TechnologyPlanService;
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

    @Override
    public int deleteByPrimaryKey(String[] ids) {
        int j = 0;
        for (int i = 0; i < ids.length ; i++){
            technologyPlanMapper.deleteByPrimaryKey(ids[i]);
            j++;
        }

        return j;
    }

    @Override
    public int updateByPrimaryKeySelective(TechnologyPlan technologyPlan) {
        return technologyPlanMapper.updateByPrimaryKeySelective(technologyPlan);
    }

    @Override
    public int insertSelective(TechnologyPlan technologyPlan) {
        return technologyPlanMapper.insertSelective(technologyPlan);
    }

    @Override
    public List<TechnologyPlan> selectByIdLike(String id) {
        String idLike = "%" + id + "%";

        return technologyPlanMapper.selectByIdLike(idLike);
    }

    @Override
    public List<TechnologyPlan> selectByNameLike(String name) {
        String nameLike = "%" + name + "%";

        return technologyPlanMapper.selectByNameLike(nameLike);
    }

    public List<TechnologyPlan> selectLeftJoin() {
        return technologyPlanMapper.selectLeftJoin();
    }

}
