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
     List<Custom> selectByExample(CustomExample example);
     int updateByPrimaryKeySelective(Custom record);
}
