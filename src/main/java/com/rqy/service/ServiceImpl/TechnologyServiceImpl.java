package com.rqy.service.ServiceImpl;

import com.rqy.domain.Technology;
import com.rqy.domain.TechnologyExample;
import com.rqy.mapper.TechnologyMapper;
import com.rqy.service.TechnologyService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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
}

