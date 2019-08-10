package com.rqy.controller.employee;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rqy.domain.employee.Employee;
import com.rqy.domain.employee.EmployeeExample;
import com.rqy.utils.PageBean;
import com.rqy.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController
{
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("employee/find")
    public String find()
    {
        return "employee_list";
    }

    @RequestMapping("employee/list")
    @ResponseBody
    public PageBean<Employee> list(int page, int rows)
    {
        //开启分页：设置了分页格式：页码和每页行数
        PageHelper.startPage(page, rows);
        EmployeeExample employeeExample = new EmployeeExample();
        //本来通过类似employeeExample.createCriteria().andBirthdayBetween()这种来获得条件，
        //现在通过PageHelper可以直接获得页面对应信息

        //获取的信息，不仅仅包含employeeList;
        List<Employee> employeeList = employeeService.selectByExample(employeeExample);
        PageInfo<Employee> employeePageInfo = new PageInfo<Employee>(employeeList);
        PageBean<Employee> pageBean = new PageBean<Employee>(employeePageInfo.getTotal(), employeeList);
        return pageBean;
    }

    //新增：
    @RequestMapping("employee/add_judge")
    @ResponseBody
    public Map add_judge()
    {
        HashMap<String, String> map = new HashMap<>();
        return map;
    }

    @RequestMapping("employee/add")
    public String add()
    {
        return "employee_add";
    }

    @RequestMapping("employee/insert")
    @ResponseBody
    public Map insert(Employee employee)
    {
        int insertans = employeeService.insertSelective(employee);
        HashMap<String, String> map = new HashMap<>();
        if(insertans==1)
        {
            map.put("status","200");
        }
        else
        {
            map.put("status","405");
        }
        return map;
    }

    //编辑：
    @RequestMapping("employee/edit_judge")
    @ResponseBody
    public Map edit_judge()
    {
        HashMap<String, String> map = new HashMap<>();
        return map;
    }
    @RequestMapping("employee/edit")
    public String edit()
    {
        return "employee_edit";
    }
    //@RequestMapping("employee/")









}

