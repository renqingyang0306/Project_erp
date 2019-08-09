package com.rqy.service.quality;

import com.rqy.domain.ProcessMeasureCheck;

import java.util.List;

/**
 * @author 申涛涛
 * @date 2019/8/9 15:04
 */
public interface ProcessMeasureCheckService {
    List<ProcessMeasureCheck> findProcessMeasureCheckList();
    List<ProcessMeasureCheck> findPageProcessMeasureCheck(int page,int rows);

    int insertProcessMeasureCheck(ProcessMeasureCheck processMeasureCheck);
    int updateProcessMeasureCheckByPMeasureCheckId(ProcessMeasureCheck processMeasureCheck);
    int deleteProcessMeasureCheck(String pMeasureCheckId);
}
