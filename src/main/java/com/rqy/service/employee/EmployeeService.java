package com.rqy.service.employee;

import com.rqy.domain.employee.Employee;
import com.rqy.domain.employee.EmployeeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeService
{
    long countByExample(EmployeeExample example);

    int deleteByExample(EmployeeExample example);

    int deleteByPrimaryKey(String empId);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeExample example);


    Employee selectByPrimaryKey(String empId);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<Employee> selectEmployeeData();

    //注意：mapper层，返回的都是List<Employee>,在service封装为EmployPageBean
    //PageBean<Employee> selectEmployeeByPage(int page, int rows);

    List<Employee> searchEmployeeByBlurCondition(int page,int rows, EmployeeExample employeeExample);


}
