package com.rqy.service.technology;

import com.rqy.domain.Technology;
import com.rqy.domain.TechnologyExample;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @auther XXX
 * @date 2019/8/8
 * @time 16:47
 */
public interface TechnologyService {

    List<Technology> selectByExample(TechnologyExample technologyExample);



    int insertSelective(Technology technology);

    int updateByPrimaryKeySelective(Technology technology);

    int deleteByPrimaryKey(String ids);

    List<Technology> selectByIdLike(String id);

}
