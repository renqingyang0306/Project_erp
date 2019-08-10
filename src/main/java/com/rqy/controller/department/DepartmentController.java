package com.rqy.controller.department;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rqy.domain.department.Department;
import com.rqy.domain.department.DepartmentExample;
import com.rqy.service.department.DepartmentService;
import com.rqy.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;


@Controller
public class DepartmentController
{
    @Autowired
    DepartmentService departmentService;
    @RequestMapping("department/find")
    public String find()
    {
        return "department_list";
    }

    @RequestMapping("department/list")
    @ResponseBody
    /*public List<Department> list()
    {
        DepartmentExample departmentExample = new DepartmentExample();
        List<Department> departmentList = departmentService.selectByExample(departmentExample);
        return departmentList;
    }*/

    public PageBean<Department> list(int page,int rows)
    {
        //开启分页，提供页面格式信息
        PageHelper.startPage(page,rows);
        //新建对象，获取了页面格式信息；
        DepartmentExample departmentExample = new DepartmentExample();
        //获取各个department信息
        List<Department> departmentList = departmentService.selectByExample(departmentExample);
        //封装获取页面上的department总信息：
        PageInfo<Department> departmentPageInfo = new PageInfo<Department>(departmentList);
        //构造pageBean:
        PageBean<Department> departmentPageBean = new PageBean<>( departmentList,departmentPageInfo.getTotal());
        return departmentPageBean;
    }

    //添加前：
//department_list.jsp 让add_judge函数为空，将调用departmentAddWindow对应id出的href:department/add;
    @RequestMapping("department/add_judge")
    @ResponseBody //通过抓包可看到一个{}，说明是个json数据，要通过@ResponseBody进行接收
    public Map add_judge()
    {
        HashMap<String, Object> map = new HashMap<>();
        //为空，在jsp页面中，将自动跳转到department_add.jsp
        return map;//其实可以返回一个null，返回map是便于代码阅读
    }
    //department_list.jsp,通过该url，跳转到department_add.jsp：
    //通过抓包，可以看出该url，然后，通过该映射，转到department_add.jsp，跳出添加弹框；
    @RequestMapping("department/add")
    public String add()
    {
        return "department_add";
    }

    //具体添加操作：

    //提交按钮对应的url为：department/insert;//抓包可以看到！
    @RequestMapping("department/insert")
    @ResponseBody
    public HashMap<String,String> insert(Department department)
    {
        HashMap<String, String> statusMap = new HashMap<>();
        int insertans = departmentService.insert(department);
        if(insertans==1)
        {
            statusMap.put("status","200");
        }
        else
        {
            statusMap.put("status","405");
        }
        return statusMap;
    }

    //编辑：抓包：可以看到：department/edit_judge ,空，则通过department_list内跳到department/edit
    @RequestMapping("department/edit_judge")
    @ResponseBody
    public Map edit_judge()
    {
        HashMap<String, Object> map = new HashMap<>();
        return map;
    }
    //通过url，跳到department_edit.jsp页面
    @RequestMapping("department/edit")
    public String edit()
    {
        return "department_edit";
    }

    @RequestMapping("department/update_all")
    @ResponseBody // 注意xxxByExample 和 ByPrimaryKey不同，前者不需要参数，后者需要！
    public Map update_all(Department department)
    {
        int updateans = departmentService.updateByPrimaryKeySelective(department);
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
    @RequestMapping("department/delete_judge")
    @ResponseBody
    public Map delete_judge()
    {
        HashMap<Object, Object> map = new HashMap<>();
        return map;
    }
    @RequestMapping("department/delete")
    public String delete()
    {
        return "department_delete";
    }

    @RequestMapping("department/delete_batch")
    @ResponseBody
    //通过department_list.jsp可以知道 里面有getDepartmentSelectionsIds返回ids，
    //而getDepartmentSelectionsIds函数，返回结果是，各个字符串用，拼接而成！！所以
    //注意：参数，必须是ids：且用Arrays.asList对拼接字符串进行还原！
    public Map delete_batch(String ids)
    {
        //将拼接字符串--还原为字符串数组列表：
        String[] splitans = ids.split(",");
        List<String> stringList = Arrays.asList(splitans);
        ArrayList<String> stringArrayList = new ArrayList<>(stringList);
        //删除条件封装：注意：不能用DepartmentNameIn...;因为如果胡乱起的名字，会导致无法删除！
        DepartmentExample departmentExample = new DepartmentExample();
        departmentExample.createCriteria().andDepartmentIdIn(stringArrayList);
        //执行删除：
        int deleteans = departmentService.deleteByExample(departmentExample);
        //注意可能为多个删除：
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

    //模糊查询：
   /* @RequestMapping("search_department_by_departmentId")
    @ResponseBody
    public */

    @RequestMapping("department/get_data")
    @ResponseBody
    public List<Department> get_data()
    {
        return departmentService.selectByExample(new DepartmentExample());
    }
}
