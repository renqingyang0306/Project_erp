package com.rqy.service.technology;

import com.rqy.domain.*;
import com.rqy.domain.Process;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @auther XXX
 * @date 2019/8/8
 * @time 21:17
 */
public interface ProcessService {
    List<Process> selectByExample(ProcessExample processExample);

    int insertSelective(Process process);

    int updateByPrimaryKeySelective(Process process);

    int deleteByPrimaryKey(String[] ids);

    List<Process> selectByIdLike(String id);

    List<Process> selectByTechnologyPlanIdLike(String pid);

    Process selectByPrimaryKey(String id);
}
