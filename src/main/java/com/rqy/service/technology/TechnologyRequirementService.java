package com.rqy.service.technology;

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

    List<TechnologyRequirement> selectLeftJoin();

    int deleteByPrimaryKey(String[] ids);

    int updateByPrimaryKeySelective(TechnologyRequirement technologyRequirement);

    int insertSelective(TechnologyRequirement technologyRequirement);

    List<TechnologyRequirement> selectByNameLike(String name);

    List<TechnologyRequirement> selectByIdLike(String id);

}
