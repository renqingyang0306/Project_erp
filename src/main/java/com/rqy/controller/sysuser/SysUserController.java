package com.rqy.controller.sysuser;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import com.rqy.domain.SysUserExample;
import com.rqy.domain.sysuser.SysUser;
import com.rqy.service.sysuser.SysUserService;
import com.rqy.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SysUserController
{
    @Autowired
    SysUserService sysUserService;
    //通过find找到user_list.jsp
    @RequestMapping("user/find")
    public String find()
    {
        return "user_list";
    }
    //通过user_list.jsp上的user/list，获取PageBean:
    @RequestMapping("user/list")
    @ResponseBody
    public PageBean<SysUser> list(int page,int rows)
    {
        PageHelper.startPage(page,rows);
        SysUserExample sysUserExample = new SysUserExample();
        List<SysUser> sysUserList = sysUserService.selectByExample(sysUserExample);

        PageInfo<SysUser> sysUserPageInfo = new PageInfo<>(sysUserList);
        PageBean<SysUser> sysUserPageBean = new PageBean<>(sysUserList, sysUserPageInfo.getTotal());
        return sysUserPageBean;
    }

    //新增：
    @RequestMapping("sysuser/add_judge")
    @ResponseBody
    public Map add_judge()
    {
        HashMap<MysqlxDatatypes.Scalar.String, MysqlxDatatypes.Scalar.String> map = new HashMap<>();
        return map;
    }

    @RequestMapping("user/add")
    public MysqlxDatatypes.Scalar.String add()
    {
        return "user_add";
    }

    @RequestMapping("sysuser/insert")
    @ResponseBody
    public Map insert(SysUser sysUser)
    {
        int insertans = sysUserService.insertSelective(sysUser);
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
    @RequestMapping("sysuser/edit_judge")
    @ResponseBody
    public Map edit_judge()
    {
        HashMap<String, String> map = new HashMap<>();
        return map;
    }
    @RequestMapping("user/edit")
    public String edit()
    {
        return "user_edit";
    }
    @RequestMapping("sysuser/update_all")
    @ResponseBody
    public Map update_all(SysUser sysUser)
    {
        int updateans = sysUserService.updateByPrimaryKeySelective(sysUser);
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
    @RequestMapping("sysuser/delete_judge")
    @ResponseBody
    public Map delete_judge()
    {
        HashMap<String, String> map = new HashMap<>();
        return map;
    }
    @RequestMapping("sysuser/delete")
    public String delete()
    {
        return "sysuser_delete";
    }
    @RequestMapping("sysuser/delete_batch")
    @ResponseBody //注意到employee_list.jsp中查看getEmployeeSelectionsIds函数--搜索！
    public Map delete_batch(String ids)
    {
        //ids是各行对象封装后empId拼接成的字符串，要进行还原：
        String[] stringsplit = ids.split(",");
        //还原后，要添加到数组中：注意是EmpId的集合！
        List<String> stringList = Arrays.asList(stringsplit);
        //设置一下删除条件：
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andIdIn(stringList);
        //通过service层调用xml中的sql进行操作：
        int deleteans = sysUserService.deleteByExample(sysUserExample);
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
    @RequestMapping("sysuser/search_user_by_userId")
    @ResponseBody
    public PageBean<SysUser> search_user_by_userId(int page,int rows,String searchValue)
    {
        //封装查询条件：
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andIdLike("%"+searchValue+"%");
        //执行搜索：
        List<SysUser> sysUserList = sysUserService.searchEmployeeByBlurCondition(page, rows, sysUserExample);
        //封装为PageBean
        PageInfo<SysUser> sysUserPageInfo = new PageInfo<>(sysUserList);
        PageBean<SysUser> sysUserPageBean = new PageBean<>(sysUserList, sysUserPageInfo.getTotal());
        return sysUserPageBean;

    }
    //employee模糊查询-按Name：
    @RequestMapping("sysuser/search_user_by_userName")
    @ResponseBody
    public PageBean<SysUser> search_user_by_userName(int page,int rows,String searchValue)
    {
        //封装查询条件：
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andUsernameLike("%"+searchValue+"%");
        //执行搜索：
        List<SysUser> sysUserList = sysUserService.searchEmployeeByBlurCondition(page, rows, sysUserExample);
        //封装为PageBean
        PageInfo<SysUser> sysUserPageInfo = new PageInfo<>(sysUserList);
        PageBean<SysUser> sysUserPageBean = new PageBean<>(sysUserList, sysUserPageInfo.getTotal());
        return sysUserPageBean;

    }



    //共其它部门调用的接口：其它部门点击链接，发出employee/get/empId这个url; command+shift+r全局搜索，可以见到其它jsp中的这个href
    @RequestMapping("sysuser/get/{userId}")
    @ResponseBody
    public SysUser get(@PathVariable String userId)
    {
        SysUser sysUser = sysUserService.selectByPrimaryKey(userId);
        return sysUser;
    }
    @RequestMapping("sysuser/get_data")
    @ResponseBody
    public List<SysUser> get_data()
    {
        List<SysUser> sysUserList = sysUserService.selectByExample(new SysUserExample());
        return sysUserList;
    }



}
