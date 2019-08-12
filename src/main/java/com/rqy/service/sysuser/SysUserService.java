package com.rqy.service.sysuser;

import com.rqy.domain.SysUserExample;
import com.rqy.domain.sysuser.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserService
{
    long countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    List<SysUser> searchEmployeeByBlurCondition(int page, int rows, SysUserExample sysUserExample);

}
