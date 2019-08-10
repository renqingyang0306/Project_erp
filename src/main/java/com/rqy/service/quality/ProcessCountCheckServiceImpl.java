package com.rqy.service.quality;

import com.github.pagehelper.PageHelper;
import com.rqy.domain.ProcessCountCheck;
import com.rqy.domain.ProcessCountCheckExample;
import com.rqy.mapper.ProcessCountCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 申涛涛
 * @date 2019/8/9 15:15
 */
@Service
public class ProcessCountCheckServiceImpl implements ProcessCountCheckService {
    @Autowired
    ProcessCountCheckMapper processCountCheckMapper;


    @Override
    public List<ProcessCountCheck> findProcessCountCheckList() {
        ProcessCountCheckExample processCountCheckExample = new ProcessCountCheckExample();
        processCountCheckExample.createCriteria().andPCountCheckIdIsNotNull();
        List<ProcessCountCheck> processCountChecks = processCountCheckMapper.selectByExampleLiftJoin(processCountCheckExample);

        return processCountChecks;
    }

    @Override
    public List<ProcessCountCheck> findPageProcessCountCheck(int page, int rows) {
        PageHelper.startPage(page,rows);
        ProcessCountCheckExample processCountCheckExample = new ProcessCountCheckExample();
        List<ProcessCountCheck> processCountChecks = processCountCheckMapper.selectByExampleLiftJoin(processCountCheckExample);
        return processCountChecks;
    }

    @Override
    public List<ProcessCountCheck> searchPageProcessCountCheckByPCountCheckId(String pCountCheckId, int page, int rows) {
        //查询条件
        PageHelper.startPage(page, rows);
        ProcessCountCheckExample processCountCheckExample = new ProcessCountCheckExample();
        pCountCheckId = "%" + pCountCheckId + "%";
        processCountCheckExample.createCriteria().andPCountCheckIdLike(pCountCheckId);
        List<ProcessCountCheck> processCountChecks = processCountCheckMapper.selectByExampleLiftJoin(processCountCheckExample);
        return processCountChecks;
    }

    @Override
    public int insertProcessCountCheck(ProcessCountCheck processCountCheck) {
        int insert = processCountCheckMapper.insert(processCountCheck);
        return insert;
    }

    @Override
    public int updateProcessCountCheckByPCountCheckId(ProcessCountCheck processCountCheck) {
        int update = processCountCheckMapper.updateByPrimaryKey(processCountCheck);
        return update;

    }

    @Override
    public int deleteProcessCountCheck(String pCountCheckId) {
        int delete = processCountCheckMapper.deleteByPrimaryKey(pCountCheckId);
        return delete;
    }
}
