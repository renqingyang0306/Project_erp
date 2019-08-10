package com.rqy.service;

import com.rqy.domain.Custom;
import com.rqy.domain.CustomExample;

import java.util.List;

/**
 * @author 任清阳
 * @Email 1277409109@qq.com
 * @date 2019/8/8 18:27
 */
public interface CustomService {
     Custom selectByPrimaryKey(String customId);
     List<Custom> selectByExample(CustomExample example);
     List<Custom> findAllCustom(int page,int rows);
     List<Custom> findAllCustomByIdOrName(int page,int rows,CustomExample example);
     int updateByPrimaryKeySelective(Custom record);
     int updateByPrimaryKey(Custom record);
     int insert(Custom record);
     int deleteByPrimaryKey(String customId);
     int deleteByExample(CustomExample example);
}
