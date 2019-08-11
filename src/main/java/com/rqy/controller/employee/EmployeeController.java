package com.rqy.controller.employee;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rqy.domain.employee.Employee;
import com.rqy.domain.employee.EmployeeExample;

import com.rqy.service.department.DepartmentService;
import com.rqy.service.employee.EmployeeService;
import com.rqy.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
//可以通过添加@RequestMapping("employee")实现窄化请求：下面的变为@RequestMapping("find")
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
        PageBean<Employee> pageBean = new PageBean<Employee>(employeeList,employeePageInfo.getTotal());
        return pageBean;
    }
    //实现employee中按部门名称来模糊搜索：
    //这个是按部门来进行模糊搜索，与其它不同,因为EmployeeExample中没有andDepartmentNameLike,不能重用上面service方法：
    //需要使用查List的结果，进行查询！！
    @RequestMapping("employee/search_employee_by_departmentName")
    @ResponseBody
    public PageBean<Employee> search_employee_by_departmentName(int page,int rows,String searchValue)
    {
        PageHelper.startPage(page,rows);
        EmployeeExample employeeExample = new EmployeeExample();
        List<Employee> employeeList = employeeService.selectByExample(employeeExample);
        List<Employee> ansList =new ArrayList<>();
        for(Employee employee: employeeList)
        {
            //注意是模糊查询，用contains!!
            if(employee.getDepartment().getDepartmentName().contains(searchValue))
            {
                ansList.add(employee);
            }
        }
        PageInfo<Employee> employeePageInfo = new PageInfo<>(ansList);
        PageBean<Employee> employeePageBean = new PageBean<>(ansList, employeePageInfo.getTotal());
        return employeePageBean;
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
    @RequestMapping("employee/update_all")
    @ResponseBody
    public Map update_all(Employee employee)
    {
        int updateans = employeeService.updateByPrimaryKeySelective(employee);
        HashMap<String, String> map = new HashMap<>();
        if(updateans==1)
        {
            map.put("status","200");
        }
        else
        {
            map.put("status","405");
        }
        return map;
    }


    //删除：
    @RequestMapping("employee/delete_judge")
    @ResponseBody
    public Map delete_judge()
    {
        HashMap<String, String> map = new HashMap<>();
        return map;
    }
    @RequestMapping("employee/delete")
    public String delete()
    {
        return "employee_delete";
    }
    @RequestMapping("employee/delete_batch")
    @ResponseBody //注意到employee_list.jsp中查看getEmployeeSelectionsIds函数--搜索！
    public Map delete_batch(String ids)
    {
        //ids是各行对象封装后empId拼接成的字符串，要进行还原：
        String[] stringsplit = ids.split(",");
        //还原后，要添加到数组中：注意是EmpId的集合！
        List<String> stringList = Arrays.asList(stringsplit);
        //设置一下删除条件：
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andEmpIdIn(stringList);
        //通过service层调用xml中的sql进行操作：
        int deleteans = employeeService.deleteByExample(employeeExample);
        //对删除结果进行判断：注意可能是多条记录删除
        HashMap<String, String> map = new HashMap<>();
        if(deleteans!=0)
        {
            map.put("status","200");
        }
        else
        {
            map.put("status","405");
        }
        return map;
    }
    //employee模糊查询-按ID：
    @RequestMapping("employee/search_employee_by_employeeId")
    @ResponseBody
    public PageBean<Employee> search_employee_by_employeeId(int page,int rows,String searchValue)
    {
        //封装查询条件：
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andEmpIdLike("%"+searchValue+"%");
        //执行搜索：
        List<Employee> employeeList = employeeService.searchEmployeeByBlurCondition(page, rows, employeeExample);
        //封装为PageBean
        PageInfo<Employee> employeePageInfo = new PageInfo<>(employeeList);
        PageBean<Employee> employeePageBean = new PageBean<>(employeeList, employeePageInfo.getTotal());
        return employeePageBean;

    }
    //employee模糊查询-按Name：
    @RequestMapping("employee/search_employee_by_employeeName")
    @ResponseBody
    public PageBean<Employee> search_employee_by_employeeName(int page,int rows,String searchValue)
    {
        //封装查询条件：
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andEmpNameLike("%"+searchValue+"%");
        //执行搜索：
        List<Employee> employeeList = employeeService.searchEmployeeByBlurCondition(page, rows, employeeExample);
        //封装为PageBean
        PageInfo<Employee> employeePageInfo = new PageInfo<>(employeeList);
        PageBean<Employee> employeePageBean = new PageBean<>(employeeList, employeePageInfo.getTotal());
        return employeePageBean;

    }





    //共其它部门调用的接口：其它部门点击链接，发出employee/get/empId这个url; command+shift+r全局搜索，可以见到其它jsp中的这个href
    @RequestMapping("employee/get/{empId}")
    @ResponseBody
    public Employee get(@PathVariable String empId)
    {
        Employee employee = employeeService.selectByPrimaryKey(empId);
        return employee;
    }
    @RequestMapping("employee/get_data")
    @ResponseBody
    public List<Employee> get_data()
    {
        List<Employee> employeeList = employeeService.selectByExample(new EmployeeExample());
        return employeeList;
    }


}

