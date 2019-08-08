package com.rqy.controller;

import com.rqy.domain.Technology;
import com.rqy.domain.TechnologyExample;
import com.rqy.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @auther XXX
 * @date 2019/8/8
 * @time 15:57
 */
@Controller
@RequestMapping("technology")
public class TechnologyController {
    /*注入TechnologyService*/
    @Autowired
    TechnologyService technologyService;
    /*跳转到页面*/
    @RequestMapping("find")
    public String technologyFind() {

        return "technology_list";
    }
    /*获得数据*/
    @RequestMapping("list")
    @ResponseBody
    public List<Technology> technologyFindList() {
        /*查询technology表里的数据，返回list集合数据*/
        TechnologyExample technologyExample = new TechnologyExample();
        List<Technology> technologies =
                technologyService.selectByExample(technologyExample);
        return technologies;
    }
}
