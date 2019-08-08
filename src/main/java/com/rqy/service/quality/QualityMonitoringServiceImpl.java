package com.rqy.service.quality;

import com.github.pagehelper.PageHelper;
import com.rqy.domain.UnqualifyApply;
import com.rqy.domain.UnqualifyApplyExample;
import com.rqy.mapper.UnqualifyApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 申涛涛
 * @date 2019/8/8 19:38
 */
@Service
public class QualityMonitoringServiceImpl implements QualityMonitoringService {

    @Autowired
    UnqualifyApplyMapper unqualifyApplyMapper;

    @Override
    public List<UnqualifyApply> findUnqualifyApply() {
        //查询条件
        UnqualifyApplyExample unqualifyApplyExample = new UnqualifyApplyExample();
        UnqualifyApplyExample.Criteria criteria = unqualifyApplyExample.createCriteria();
        criteria.andProductIdIsNotNull();

        return unqualifyApplyMapper.selectByExample(unqualifyApplyExample);
    }

    @Override
    public List<UnqualifyApply> findPageUnqualifyApply(int pageNum,int pageSize) {
        //查询条件
        PageHelper.startPage(pageNum, pageSize);
        UnqualifyApplyExample unqualifyApplyExample = new UnqualifyApplyExample();
        //UnqualifyApplyExample.Criteria criteria = unqualifyApplyExample.createCriteria();
        List<UnqualifyApply> unqualifyApplies = unqualifyApplyMapper.selectByExample(unqualifyApplyExample);

        return unqualifyApplies;
    }
}
