package com.rqy.service;

import com.rqy.domain.Custom;
import com.rqy.domain.CustomExample;
import com.rqy.mapper.CustomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 任清阳
 * @Email 1277409109@qq.com
 * @date 2019/8/8 18:27
 */
@Component
public class CustomServiceImpl implements CustomService {
    @Autowired
    CustomMapper customMapper;
    @Override
    public List<Custom> selectByExample(CustomExample example) {
        List<Custom> customs = customMapper.selectByExample(example);
        return customs;
    }

    @Override
    public int updateByPrimaryKeySelective(Custom record) {
        return customMapper.updateByPrimaryKeySelective(record);
    }
}
