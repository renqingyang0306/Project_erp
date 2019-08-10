package com.rqy.controller.material;

import com.github.pagehelper.PageInfo;
import com.rqy.domain.MaterialConsume;
import com.rqy.domain.MaterialConsumeExample;
import com.rqy.service.material.MaterialConsumeService;
import com.rqy.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("materialConsume")
public class MaterialConsumeController {
    @Autowired
    MaterialConsumeService materialConsumeService;

    @RequestMapping("find")
    public String find() {
        return "materialConsume_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public PageBean<MaterialConsume> list(int page, int rows) {
        List<MaterialConsume> allMaterialConsume = materialConsumeService.findAllMaterialConsume(page, rows);
        PageInfo<MaterialConsume> pageInfo = new PageInfo<>(allMaterialConsume);
        PageBean<MaterialConsume> pageBean = new PageBean<>(allMaterialConsume, pageInfo.getTotal());
        return pageBean;
    }

    //新增前的判断
    @RequestMapping("add_judge")
    @ResponseBody
    public Map add_judge() {
        HashMap<String, Object> map = new HashMap<>();
        return map;
    }

    //点击新增后跳转jsp页面
    @RequestMapping("add")
    public String add() {
        return "materialConsume_add";
    }

    //新增里点击提交按钮
    @RequestMapping("insert")
    @ResponseBody
    public Map insert(MaterialConsume materialConsume) {
        int i = materialConsumeService.insert(materialConsume);
        HashMap<String, Object> map = new HashMap<>();
        if (i != 0) {
            map.put("status", "200");
        } else {
            map.put("status", "302");
        }
        return map;
    }

    //删除前的判断
    @RequestMapping("delete_judge")
    @ResponseBody
    public Map delete_judge() {
        HashMap<String, Object> map = new HashMap<>();
        return map;
    }

    ////可选择（一个或多个）删除操作
    @RequestMapping("delete_batch")
    @ResponseBody
    public Map delete_batch(String ids) {
        String[] split = ids.split(",");
        HashMap<String, Object> map = new HashMap<>();
        for (String s : split) {
            int i = materialConsumeService.deleteByPrimaryKey(s);
            if (i != 0) {
                map.put("status", "200");
            } else {
                map.put("status", "302");
            }
        }
        return map;
    }

    //编辑前的判断
    @RequestMapping("edit_judge")
    @ResponseBody
    public Map edit_judge(){
        HashMap<String, Object> map = new HashMap<>();
        return map;
    }
    //只进行备注修改
    @RequestMapping("update_note")
    @ResponseBody
    public Map update_note(MaterialConsume materialConsume){
        int i = materialConsumeService.updateByPrimaryKeySelective(materialConsume);
        HashMap<String, Object> map = new HashMap<>();
        if(i != 0){
            map.put("status","200");
        }else {
            map.put("status","302");
        }
        return map;
    }
    //点击编辑后跳转至jsp页面
    @RequestMapping("edit")
    public String edit(){
        return "materialConsume_edit";
    }
    //编辑提交后跳转
    @RequestMapping("update_all")
    @ResponseBody
    public Map update_all(MaterialConsume materialConsume){
        int i = materialConsumeService.updateByPrimaryKey(materialConsume);
        HashMap<String, Object> map = new HashMap<>();
        if(i != 0){
            map.put("status","200");
        }else {
            map.put("status","302");
        }
        return map;
    }

    //模糊查询
    @RequestMapping("search_materialConsume_by_consumeId")
    @ResponseBody
    private PageBean<MaterialConsume> search_materialConsume_by_consumeId(int page,int rows,String searchValue){
        MaterialConsumeExample example = new MaterialConsumeExample();
        example.createCriteria().andConsumeIdLike("%" + searchValue + "%");
        List<MaterialConsume> consumes = materialConsumeService.findAllMaterialConsumeByConsumeidOrWorkidOrMaterialid(page, rows, example);
        PageInfo<MaterialConsume> pageInfo = new PageInfo<>(consumes);
        PageBean<MaterialConsume> pageBean = new PageBean<>(consumes, pageInfo.getTotal());
        return pageBean;
    }
    @RequestMapping("search_materialConsume_by_workId")
    @ResponseBody
    private PageBean<MaterialConsume> search_materialConsume_by_workId(int page,int rows,String searchValue){
        MaterialConsumeExample example = new MaterialConsumeExample();
        example.createCriteria().andWorkIdLike("%" + searchValue + "%");
        List<MaterialConsume> consumes = materialConsumeService.findAllMaterialConsumeByConsumeidOrWorkidOrMaterialid(page, rows, example);
        PageInfo<MaterialConsume> pageInfo = new PageInfo<>(consumes);
        PageBean<MaterialConsume> pageBean = new PageBean<>(consumes, pageInfo.getTotal());
        return pageBean;
    }
    @RequestMapping("search_materialConsume_by_materialId")
    @ResponseBody
    private PageBean<MaterialConsume> search_materialConsume_by_materialId(int page,int rows,String searchValue){
        MaterialConsumeExample example = new MaterialConsumeExample();
        example.createCriteria().andConsumeIdLike("%" + searchValue + "%");
        List<MaterialConsume> consumes = materialConsumeService.findAllMaterialConsumeByConsumeidOrWorkidOrMaterialid(page, rows, example);
        PageInfo<MaterialConsume> pageInfo = new PageInfo<>(consumes);
        PageBean<MaterialConsume> pageBean = new PageBean<>(consumes, pageInfo.getTotal());
        return pageBean;
    }
}
