package com.rqy.service;

import com.github.pagehelper.PageHelper;
import com.rqy.domain.Work;
import com.rqy.domain.WorkExample;
import com.rqy.mapper.WorkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.security.krb5.internal.PAData;

import java.util.List;

/**
 * @author 任清阳
 * @Email 1277409109@qq.com
 * @date 2019/8/10 12:05
 */
@Component
public class WorkServcieImpl implements WorkServcie{

    @Autowired
    WorkMapper workMapper;
    @Override
    public int deleteByExample(WorkExample example) {
        return workMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String workId) {
        return workMapper.deleteByPrimaryKey(workId);
    }

    @Override
    public int insert(Work record) {
        return workMapper.insert(record);
    }

    @Override
    public List<Work> selectByExample(WorkExample example) {
        return workMapper.selectByExample(example);
    }

    @Override
    public Work selectByPrimaryKey(String workId) {
        return workMapper.selectByPrimaryKey(workId);

    }

    @Override
    public int updateByPrimaryKeySelective(Work record) {
        return workMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Work record) {
        return workMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Work> findAllWork(int page, int rows) {
        PageHelper.startPage(page,rows);
        WorkExample workExample = new WorkExample();
        List<Work> works = workMapper.selectByExample(workExample);
        return works;
    }

    @Override
    public List<Work> findAllWorkByIdOrProcessId(int page, int rows, WorkExample workExample) {
        PageHelper.startPage(page,rows);
        List<Work> works = workMapper.selectByExample(workExample);
        return works;
    }

    @Override
    public List<Work> findAllWorkByProductName(int page, int rows, String s) {
        //将参数传给方法实现分页
        PageHelper.startPage(page, rows);
        List<Work> works = workMapper.findAllWorkByProductName(s);
        return works;
    }

    @Override
    public List<Work> findAllWorkByDeviceName(int page, int rows, String s) {
        //将参数传给方法实现分页
        PageHelper.startPage(page, rows);
        List<Work> works = workMapper.findAllWorkByDeviceName(s);
        return works;
    }
}
