package com.rqy.service.quality;

import com.github.pagehelper.PageHelper;
import com.rqy.domain.FinalCountCheckExample;
import com.rqy.domain.FinalMeasuretCheck;
import com.rqy.domain.FinalMeasuretCheckExample;
import com.rqy.mapper.FinalMeasuretCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 申涛涛
 * @date 2019/8/9 14:39
 */
@Service
public class FinalMeasuretCheckServiceImpl implements FinalMeasuretCheckService {
    @Autowired
    FinalMeasuretCheckMapper finalMeasuretCheckMapper;

    @Override
    public List<FinalMeasuretCheck> findFinalMeasuretCheckList() {
        FinalMeasuretCheckExample finalMeasuretCheckExample = new FinalMeasuretCheckExample();
        FinalMeasuretCheckExample.Criteria criteria = finalMeasuretCheckExample.createCriteria();
        criteria.andOrderIdIsNotNull();
        List<FinalMeasuretCheck> finalMeasuretChecks = finalMeasuretCheckMapper.selectByExampleLiftJoin(finalMeasuretCheckExample);

        return finalMeasuretChecks;
    }

    @Override
    public List<FinalMeasuretCheck> findPageFinalMeasuretCheck(int page, int rows) {
        PageHelper.startPage(page,rows);
        FinalMeasuretCheckExample finalMeasuretCheckExample = new FinalMeasuretCheckExample();
        List<FinalMeasuretCheck> finalMeasuretChecks = finalMeasuretCheckMapper.selectByExampleLiftJoin(finalMeasuretCheckExample);
        return finalMeasuretChecks;
    }

    @Override
    public List<FinalMeasuretCheck> searchPageFinalMeasuretCheckByFMeasureCheckId(String fMeansureCheckId, int page, int rows) {
        //查询条件
        PageHelper.startPage(page,rows);
        FinalMeasuretCheckExample finalMeasuretCheckExample = new FinalMeasuretCheckExample();
        fMeansureCheckId = "%" + fMeansureCheckId + "%";
        finalMeasuretCheckExample.createCriteria().andFMeasureCheckIdLike(fMeansureCheckId);
        List<FinalMeasuretCheck> finalMeasuretChecks = finalMeasuretCheckMapper.selectByExampleLiftJoin(finalMeasuretCheckExample);

        return finalMeasuretChecks;
    }

    @Override
    public List<FinalMeasuretCheck> searchPageFinalMeasuretCheckByOrderId(String orderId, int page, int rows) {
        //查询条件
        PageHelper.startPage(page,rows);
        FinalMeasuretCheckExample finalMeasuretCheckExample = new FinalMeasuretCheckExample();
        orderId = "%" + orderId + "%";
        finalMeasuretCheckExample.createCriteria().andOrderIdLike(orderId);
        List<FinalMeasuretCheck> finalMeasuretChecks = finalMeasuretCheckMapper.selectByExampleLiftJoin(finalMeasuretCheckExample);

        return finalMeasuretChecks;
    }

    @Override
    public int insertFinalMeasuretCheck(FinalMeasuretCheck finalMeasuretCheck) {
        int insert = finalMeasuretCheckMapper.insert(finalMeasuretCheck);
        return insert;
    }

    @Override
    public int updateFinalMeasuretCheckByFMeasureCheckId(FinalMeasuretCheck finalMeasuretCheck) {
        int update = finalMeasuretCheckMapper.updateByPrimaryKey(finalMeasuretCheck);
        return update;
    }

    @Override
    public int deleteFinalMeasuretCheck(String fMeasureCheckId) {
        int delete = finalMeasuretCheckMapper.deleteByPrimaryKey(fMeasureCheckId);
        return delete;
    }
}
