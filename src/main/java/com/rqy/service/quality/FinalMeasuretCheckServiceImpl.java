package com.rqy.service.quality;

import com.github.pagehelper.PageHelper;
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
        List<FinalMeasuretCheck> finalMeasuretChecks = finalMeasuretCheckMapper.selectByExample(finalMeasuretCheckExample);

        return finalMeasuretChecks;
    }

    @Override
    public List<FinalMeasuretCheck> findPageFinalMeasuretCheck(int page, int rows) {
        PageHelper.startPage(page,rows);
        FinalMeasuretCheckExample finalMeasuretCheckExample = new FinalMeasuretCheckExample();
        List<FinalMeasuretCheck> finalMeasuretChecks = finalMeasuretCheckMapper.selectByExample(finalMeasuretCheckExample);
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
