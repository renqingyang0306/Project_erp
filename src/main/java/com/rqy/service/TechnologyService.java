package com.rqy.service;

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
}
