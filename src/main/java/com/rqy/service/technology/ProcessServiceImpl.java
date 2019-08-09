package com.rqy.service.technology;

import com.rqy.domain.Process;
import com.rqy.domain.ProcessExample;
import com.rqy.mapper.ProcessMapper;
import com.rqy.service.technology.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * @auther XXX
 * @date 2019/8/8
 * @time 21:18
 */
@Service
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    ProcessMapper processMapper;
    @Override
    public List<Process> selectByExample(ProcessExample processExample) {
        return processMapper.selectByExample(processExample);
    }

    @Override
    public int insertSelective(Process process) {
        return processMapper.insertSelective(process);
    }

    @Override
    public int updateByPrimaryKeySelective(Process process) {
        return processMapper.updateByPrimaryKeySelective(process);
    }

    @Override
    public int deleteByPrimaryKey(String ids) {
        return processMapper.deleteByPrimaryKey(ids);
    }
}
