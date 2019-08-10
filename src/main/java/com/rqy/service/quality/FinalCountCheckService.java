package com.rqy.service.quality;

import com.rqy.domain.FinalCountCheck;

import java.util.List;

/**
 * @author 申涛涛
 * @date 2019/8/9 14:53
 */
public interface FinalCountCheckService {
    List<FinalCountCheck> findFinalCountCheckList();
    List<FinalCountCheck> findPageFinalCountCheck(int page,int rows);

    List<FinalCountCheck> searchPageFinalCountCheckByFCountCheckId(String fCountCheckId, int page,int rows);
    List<FinalCountCheck> searchPageFinalCountCheckByOrderId(String orderId, int page,int rows);

    int insertFinalCountCheck(FinalCountCheck finalCountCheck);
    int updateFinalCountCheckByFCountCheckId(FinalCountCheck finalCountCheck);
    int deleteFinalCountCheck(String fCountCheckId);
}
