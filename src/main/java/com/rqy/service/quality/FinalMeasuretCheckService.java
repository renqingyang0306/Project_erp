package com.rqy.service.quality;

import com.rqy.domain.FinalMeasuretCheck;

import java.util.List;

/**
 * @author 申涛涛
 * @date 2019/8/9 14:38
 */
public interface FinalMeasuretCheckService {
    List<FinalMeasuretCheck> findFinalMeasuretCheckList();
    List<FinalMeasuretCheck> findPageFinalMeasuretCheck(int page,int rows);

    int insertFinalMeasuretCheck(FinalMeasuretCheck finalMeasuretCheck);
    int updateFinalMeasuretCheckByFMeasureCheckId(FinalMeasuretCheck finalMeasuretCheck);
    int deleteFinalMeasuretCheck(String fMeasureCheckId);
}
