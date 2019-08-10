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
public class UnqualityApplyServiceImpl implements UnqualityApplyService {

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
    public List<UnqualifyApply> findPageUnqualifyApply(int page,int rows) {
        //查询条件
        PageHelper.startPage(page, rows);
        UnqualifyApplyExample unqualifyApplyExample = new UnqualifyApplyExample();
        //UnqualifyApplyExample.Criteria criteria = unqualifyApplyExample.createCriteria();
//        List<UnqualifyApply> unqualifyApplies = unqualifyApplyMapper.selectByExample(unqualifyApplyExample);
        List<UnqualifyApply> unqualifyApplies = unqualifyApplyMapper.selectByExampleLiftJoin(unqualifyApplyExample);

        return unqualifyApplies;
    }

    @Override
    public List<UnqualifyApply> searchPageUnqualifyApplyByUnqualifyId(String unqualifyId, int page, int rows) {
        //查询条件
        PageHelper.startPage(page, rows);
        UnqualifyApplyExample unqualifyApplyExample = new UnqualifyApplyExample();
        unqualifyId = "%" + unqualifyId + "%";
        unqualifyApplyExample.createCriteria().andUnqualifyApplyIdLike(unqualifyId);
        List<UnqualifyApply> unqualifyApplies = unqualifyApplyMapper.selectByExampleLiftJoin(unqualifyApplyExample);
        return unqualifyApplies;
    }

    @Override
    public List<UnqualifyApply> searchPageUnqualifyApplyByProductName(String productName, int page, int rows) {
        //查询条件
        PageHelper.startPage(page, rows);
        //UnqualifyApplyExample unqualifyApplyExample = new UnqualifyApplyExample();
        productName = "%" + productName + "%";
        List<UnqualifyApply> unqualifyApplies = unqualifyApplyMapper.searchByProductNameLiftJoin(productName);
        return unqualifyApplies;
    }

    @Override
    public int insertUnqualifyApply(UnqualifyApply unqualifyApply) {
        int insert = unqualifyApplyMapper.insert(unqualifyApply);
        return insert;
    }

    @Override
    public int updateUnqualifyApplyByUnqualifyApplyId(UnqualifyApply unqualifyApply) {
        int update = unqualifyApplyMapper.updateByPrimaryKey(unqualifyApply);
        return update;
    }

    @Override
    public int deleteUnqualifyApply(String unqualifyApplyId) {
        int delete = unqualifyApplyMapper.deleteByPrimaryKey(unqualifyApplyId);
        return delete;
    }
}
