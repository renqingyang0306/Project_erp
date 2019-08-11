package com.rqy.service.department;

import com.github.pagehelper.PageHelper;
import com.rqy.domain.department.Department;
import com.rqy.domain.department.DepartmentExample;
import com.rqy.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService
{
    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public long countByExample(DepartmentExample example)
    {
        return departmentMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(DepartmentExample example)
    {
        return departmentMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String departmentId)
    {
        return departmentMapper.deleteByPrimaryKey(departmentId);
    }

    @Override
    public int insert(Department record)
    {
        return departmentMapper.insert(record);
    }

    @Override
    public int insertSelective(Department record)
    {
        return departmentMapper.insertSelective(record);
    }

    @Override
    public List<Department> selectByExample(DepartmentExample example)
    {
        List<Department> departmentList = departmentMapper.selectByExample(example);

        return departmentList;
    }

    @Override
    public Department selectByPrimaryKey(String departmentId)
    {
        return departmentMapper.selectByPrimaryKey(departmentId);
    }

    @Override
    public int updateByExampleSelective(Department record, DepartmentExample example)
    {
        return departmentMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Department record, DepartmentExample example)
    {
        return departmentMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Department record)
    {
        return departmentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Department record)
    {
        return departmentMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Department> searchDepartmentByBlurcondition(int page, int rows, DepartmentExample departmentExample)
    {
        PageHelper.startPage(page,rows);
        //通过查询条件封装对象departmentExample，实现不同查询条件id 和 name的封装！！
        List<Department> departmentList = departmentMapper.selectByExample(departmentExample);
        return departmentList;
    }

    /*@Override
    public List<String> selectAllDepartmentName(DepartmentExample departmentExample)
    {
        List<Department> departmentList = departmentMapper.selectByExample(departmentExample);
        ArrayList<String> nameList = new ArrayList<>();
        for(Department department:departmentList)
        {
            nameList.add(department.getDepartmentName());
        }
        return nameList;
    }*/
}
