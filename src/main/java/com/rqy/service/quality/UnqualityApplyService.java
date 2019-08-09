package com.rqy.service.quality;

import com.rqy.domain.UnqualifyApply;
import com.rqy.domain.UnqualifyApplyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 申涛涛
 * @date 2019/8/8 19:40
 */
public interface UnqualityApplyService {
    List<UnqualifyApply> findUnqualifyApply();
    List<UnqualifyApply> findPageUnqualifyApply(int page,int rows);

    int insertUnqualifyApply(UnqualifyApply unqualifyApply);
    int updateUnqualifyApplyByUnqualifyApplyId(UnqualifyApply unqualifyApply);
    int deleteUnqualifyApply(String unqualifyApplyId);
}
