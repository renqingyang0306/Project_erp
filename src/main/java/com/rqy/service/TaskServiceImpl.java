package com.rqy.service;

import com.github.pagehelper.PageHelper;
import com.rqy.domain.Task;
import com.rqy.domain.TaskExample;
import com.rqy.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 任清阳
 * @Email 1277409109@qq.com
 * @date 2019/8/10 18:04
 */
@Component
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskMapper taskMapper;

    @Override
    public int deleteByExample(TaskExample example) {
        return taskMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String taskId) {
        return taskMapper.deleteByPrimaryKey(taskId);
    }

    @Override
    public int insert(Task record) {
        return taskMapper.insert(record);
    }

    @Override
    public List<Task> selectByExample(TaskExample example) {
        return taskMapper.selectByExample(example);
    }

    @Override
    public Task selectByPrimaryKey(String taskId) {
        return taskMapper.selectByPrimaryKey(taskId);
    }

    @Override
    public int updateByPrimaryKeySelective(Task record) {
        return taskMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Task record) {
        return taskMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Task> findAllTask(int page, int rows) {
        PageHelper.startPage(page,rows);
        return taskMapper.selectByExample(new TaskExample());
    }

    @Override
    public List<Task> findAllTaskByIdOrWorkIdOrManufactureSn(int page, int rows, TaskExample taskExample) {
        PageHelper.startPage(page,rows);
        return taskMapper.selectByExample(taskExample);
    }
}
