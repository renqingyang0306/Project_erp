package com.rqy.service.quality;

import com.rqy.domain.UnqualifyApply;
import com.rqy.domain.UnqualifyApplyExample;

import java.util.List;

/**
 * @author 申涛涛
 * @date 2019/8/8 19:40
 */
public interface QualityMonitoringService {
    List<UnqualifyApply> findUnqualifyApply();
    List<UnqualifyApply> findPageUnqualifyApply(int pageNum,int pageSize);

}
