package com.rqy.service.quality;

import com.github.pagehelper.PageHelper;
import com.rqy.domain.ProcessMeasureCheck;
import com.rqy.domain.ProcessMeasureCheckExample;
import com.rqy.mapper.ProcessMeasureCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 申涛涛
 * @date 2019/8/9 15:05
 */
@Service
public class ProcessMeasureCheckServiceImpl implements ProcessMeasureCheckService {
    @Autowired
    ProcessMeasureCheckMapper processMeasureCheckMapper;


    @Override
    public List<ProcessMeasureCheck> findProcessMeasureCheckList() {
        ProcessMeasureCheckExample processMeasureCheckExample = new ProcessMeasureCheckExample();
        processMeasureCheckExample.createCriteria().andPMeasureCheckIdIsNotNull();
        List<ProcessMeasureCheck> processMeasureChecks = processMeasureCheckMapper.selectByExample(processMeasureCheckExample);
        return processMeasureChecks;
    }

    @Override
    public List<ProcessMeasureCheck> findPageProcessMeasureCheck(int page, int rows) {
        //查询条件
        PageHelper.startPage(page, rows);
        ProcessMeasureCheckExample processMeasureCheckExample = new ProcessMeasureCheckExample();
        List<ProcessMeasureCheck> processMeasureChecks = processMeasureCheckMapper.selectByExample(processMeasureCheckExample);

        return processMeasureChecks;
    }

    @Override
    public int insertProcessMeasureCheck(ProcessMeasureCheck processMeasureCheck) {
        int insert = processMeasureCheckMapper.insert(processMeasureCheck);
        return insert;
    }

    @Override
    public int updateProcessMeasureCheckByPMeasureCheckId(ProcessMeasureCheck processMeasureCheck) {
        int update = processMeasureCheckMapper.updateByPrimaryKey(processMeasureCheck);
        return update;
    }

    @Override
    public int deleteProcessMeasureCheck(String pMeasureCheckId) {
        int delete = processMeasureCheckMapper.deleteByPrimaryKey(pMeasureCheckId);
        return delete;
    }
}
