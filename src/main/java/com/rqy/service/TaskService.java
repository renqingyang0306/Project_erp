package com.rqy.service;

import com.rqy.domain.Task;
import com.rqy.domain.TaskExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 任清阳
 * @Email 1277409109@qq.com
 * @date 2019/8/10 18:04
 */
public interface TaskService {
    int deleteByExample(TaskExample example);

    int deleteByPrimaryKey(String taskId);

    int insert(Task record);

    List<Task> selectByExample(TaskExample example);

    Task selectByPrimaryKey(String taskId);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);

    List<Task> findAllTask(int page, int rows);

    List<Task> findAllTaskByIdOrWorkIdOrManufactureSn(int page, int rows, TaskExample taskExample);
}
