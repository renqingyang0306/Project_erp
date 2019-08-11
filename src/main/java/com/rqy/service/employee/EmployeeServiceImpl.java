package com.rqy.service.employee;

import com.github.pagehelper.PageHelper;
import com.rqy.domain.employee.Employee;
import com.rqy.domain.employee.EmployeeExample;
import com.rqy.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public long countByExample(EmployeeExample example)
    {
        return employeeMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(EmployeeExample example)
    {
        return employeeMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String empId)
    {
        return employeeMapper.deleteByPrimaryKey(empId);
    }

    @Override
    public int insert(Employee record)
    {
        return employeeMapper.insert(record);
    }

    @Override
    public int insertSelective(Employee record)
    {
        return employeeMapper.insert(record);
    }

    @Override
    public List<Employee> selectByExample(EmployeeExample example)
    {
        List<Employee> employeeList = employeeMapper.selectByExample(example);
        return employeeList;
    }


    @Override
    public Employee selectByPrimaryKey(String empId)
    {
        return employeeMapper.selectByPrimaryKey(empId);
    }

    @Override
    public int updateByExampleSelective(Employee record, EmployeeExample example)
    {
        return employeeMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Employee record, EmployeeExample example)
    {
        return employeeMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Employee record)
    {
        return employeeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Employee record)
    {
        return employeeMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Employee> selectEmployeeData()
    {
        EmployeeExample employeeExample = new EmployeeExample();
        return employeeMapper.selectByExample(employeeExample);
    }

    @Override
    public List<Employee> searchEmployeeByBlurCondition(int page, int rows, EmployeeExample employeeExample)
    {
        //开启分页，抓取分页信息：
        PageHelper.startPage(page,rows);
        List<Employee> employeeList = employeeMapper.selectByExample(employeeExample);
        return employeeList;
    }


    /*@Override
    public PageBean<Employee> selectEmployeeByPage(int page, int rows)
    {
        PageBean<Employee> employeePageBean = new PageBean<>();
        EmployeeExample employeeExample = new EmployeeExample();
        //获取的json数据量
        long pageSize = employeeMapper.countByExample(employeeExample);
        rows = pageSize <rows ? (int) pageSize : rows;
        int offset = (page -1) * rows;
        //PageBean<Employee> pageBean = employeeMapper.selectEmployeeByPage(page, offset);
          List<Employee> employeeList = employeeMapper.selectEmployeeByPage(rows, offset);
          employeePageBean.setTotal((int)pageSize);
          employeePageBean.setRows(employeeList);
          return employeePageBean;
    }*/

}
