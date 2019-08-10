package com.rqy.service.technology;

import com.rqy.domain.TechnologyPlan;
import com.rqy.domain.TechnologyRequirement;
import com.rqy.domain.TechnologyRequirementExample;
import com.rqy.mapper.TechnologyRequirementMapper;
import com.rqy.service.technology.TechnologyRequirementService;
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
    public List<TechnologyRequirement> selectLeftJoin() {
        return technologyRequirementMapper.selectLeftJoin();
    }

    @Override
    public int deleteByPrimaryKey(String[] ids) {
        int j = 0;
        for (int i = 0; i < ids.length ; i++){
            technologyRequirementMapper.deleteByPrimaryKey(ids[i]);
            j++;
        }
        return j;
    }

    @Override
    public int updateByPrimaryKeySelective(TechnologyRequirement technologyRequirement) {
        return technologyRequirementMapper.updateByPrimaryKeySelective(technologyRequirement);
    }

    @Override
    public int insertSelective(TechnologyRequirement technologyRequirement) {
        return technologyRequirementMapper.insertSelective(technologyRequirement);
    }

    @Override
    public List<TechnologyRequirement> selectByIdLike(String id) {
        String idLike = "%" + id + "%";

        return technologyRequirementMapper.selectByIdLike(idLike);
    }

    @Override
    public List<TechnologyRequirement> selectByNameLike(String name) {
        String nameLike = "%" + name + "%";

        return technologyRequirementMapper.selectByNameLike(nameLike);
    }
}
