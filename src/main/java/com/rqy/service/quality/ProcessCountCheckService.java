package com.rqy.service.quality;

import com.rqy.domain.ProcessCountCheck;

import java.util.List;

/**
 * @author 申涛涛
 * @date 2019/8/9 15:14
 */
public interface ProcessCountCheckService {
    List<ProcessCountCheck> findProcessCountCheckList();
    List<ProcessCountCheck> findPageProcessCountCheck(int page,int rows);

    int insertProcessCountCheck(ProcessCountCheck processCountCheck);
    int updateProcessCountCheckByPCountCheckId(ProcessCountCheck processCountCheck);
    int deleteProcessCountCheck(String pCountCheckId);
}
