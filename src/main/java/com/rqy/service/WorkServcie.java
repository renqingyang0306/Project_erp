package com.rqy.service;

import com.rqy.domain.Work;
import com.rqy.domain.WorkExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 任清阳
 * @Email 1277409109@qq.com
 * @date 2019/8/10 12:05
 */
public interface WorkServcie {
    int deleteByExample(WorkExample example);

    int deleteByPrimaryKey(String workId);

    int insert(Work record);


    List<Work> selectByExample(WorkExample example);

    Work selectByPrimaryKey(String workId);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);

    List<Work> findAllWork(int page, int rows);
<<<<<<< HEAD
=======

    List<Work> findAllWorkByIdOrProcessId(int page, int rows, WorkExample workExample);

    List<Work> findAllWorkByProductName(int page, int rows, String s);

    List<Work> findAllWorkByDeviceName(int page, int rows, String s);
>>>>>>> cdfeb3f536dd5ea1a6c36da8d2550c3972d3bbba
}
