package com.rqy.service.technology;

import com.rqy.domain.Technology;
import com.rqy.domain.TechnologyExample;
import com.rqy.mapper.TechnologyMapper;
import com.rqy.service.technology.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @auther XXX
 * @date 2019/8/8
 * @time 16:48
 */
@Service
public class TechnologyServiceImpl implements TechnologyService {
    @Autowired
    TechnologyMapper technologyMapper;
    /*查询所有的technology*/
    public List<Technology> selectByExample(TechnologyExample technologyExample){
        /*根据example进行查询*/
        return technologyMapper.selectByExample(technologyExample);
    }

    /*inset*/
    public int insertSelective(Technology technology){
        return technologyMapper.insertSelective(technology);
    }

    /*update*/
    public int updateByPrimaryKeySelective(Technology technology){
        return technologyMapper.updateByPrimaryKeySelective(technology);
    }

    /*delete*/
    public int deleteByPrimaryKey(String ids){
        return technologyMapper.deleteByPrimaryKey(ids);
    }

    @Override
    public List<Technology> selectByIdLike(String id) {
        String idlike = "%" + id + "%";

        return technologyMapper.selectByIdLike(idlike);
    }
}

