package com.rqy.service.user;

import com.github.pagehelper.PageHelper;
import com.rqy.domain.SysUserExample;
import com.rqy.domain.sysuser.SysUser;
import com.rqy.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.jvm.hotspot.debugger.Page;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService
{
    @Autowired
    SysUserMapper sysUserMapper;
    @Override
    public long countByExample(SysUserExample example)
    {
        return sysUserMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SysUserExample example)
    {
        return sysUserMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String id)
    {
        return sysUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysUser record)
    {
        return sysUserMapper.insert(record);
    }

    @Override
    public int insertSelective(SysUser record)
    {
        return sysUserMapper.insertSelective(record);
    }

    @Override
    public List<SysUser> selectByExample(SysUserExample example)
    {
        return sysUserMapper.selectByExample(example);
    }

    @Override
    public SysUser selectByPrimaryKey(String id)
    {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(SysUser record, SysUserExample example)
    {
        return sysUserMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(SysUser record, SysUserExample example)
    {
        return sysUserMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser record)
    {
        return sysUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysUser record)
    {
        return sysUserMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SysUser> searchEmployeeByBlurCondition(int page, int rows, SysUserExample sysUserExample)
    {
        PageHelper.startPage(page,rows);
        List<SysUser> sysUserList = sysUserMapper.selectByExample(sysUserExample);
        return sysUserList;
    }
}
