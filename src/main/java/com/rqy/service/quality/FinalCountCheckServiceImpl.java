package com.rqy.service.quality;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rqy.domain.FinalCountCheck;
import com.rqy.domain.FinalCountCheckExample;
import com.rqy.mapper.FinalCountCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 申涛涛
 * @date 2019/8/9 14:54
 */
@Service
public class FinalCountCheckServiceImpl implements FinalCountCheckService {

    @Autowired
    FinalCountCheckMapper finalCountCheckMapper;

    //查询 FinalMeasuretCheck 的全部数据
    @Override
    public List<FinalCountCheck> findFinalCountCheckList() {
        FinalCountCheckExample finalCountCheckExample = new FinalCountCheckExample();
        finalCountCheckExample.createCriteria().andFCountCheckIdIsNotNull();
        List<FinalCountCheck> finalCountChecks = finalCountCheckMapper.selectByExample(finalCountCheckExample);
        return finalCountChecks;
    }

    @Override
    public List<FinalCountCheck> findPageFinalCountCheck(int page, int rows) {
        PageHelper.startPage(page,rows);
        FinalCountCheckExample finalCountCheckExample = new FinalCountCheckExample();
        List<FinalCountCheck> finalCountChecks = finalCountCheckMapper.selectByExampleLiftJoin(finalCountCheckExample);
        return finalCountChecks;
    }

    @Override
    public List<FinalCountCheck> searchPageFinalCountCheckByFCountCheckId(String fCountCheckId, int page, int rows) {
        //查询条件
        PageHelper.startPage(page,rows);
        FinalCountCheckExample finalCountCheckExample = new FinalCountCheckExample();
        fCountCheckId = "%" + fCountCheckId + "%";
        finalCountCheckExample.createCriteria().andFCountCheckIdLike(fCountCheckId);
        List<FinalCountCheck> finalCountChecks = finalCountCheckMapper.selectByExampleLiftJoin(finalCountCheckExample);
        return finalCountChecks;
    }

    @Override
    public List<FinalCountCheck> searchPageFinalCountCheckByOrderId(String orderId, int page, int rows) {
        //查询条件
        PageHelper.startPage(page,rows);
        FinalCountCheckExample finalCountCheckExample = new FinalCountCheckExample();
        orderId = "%" + orderId + "%";
        finalCountCheckExample.createCriteria().andOrderIdLike(orderId);
        List<FinalCountCheck> finalCountChecks = finalCountCheckMapper.selectByExampleLiftJoin(finalCountCheckExample);
        return finalCountChecks;
    }

    @Override
    public int insertFinalCountCheck(FinalCountCheck finalCountCheck) {
        int insert = finalCountCheckMapper.insert(finalCountCheck);
        return insert;
    }

    @Override
    public int updateFinalCountCheckByFCountCheckId(FinalCountCheck finalCountCheck) {
        int update = finalCountCheckMapper.updateByPrimaryKey(finalCountCheck);
        return update;
    }

    @Override
    public int deleteFinalCountCheck(String fCountCheckId) {
        int delete = finalCountCheckMapper.deleteByPrimaryKey(fCountCheckId);
        return delete;
    }
}
