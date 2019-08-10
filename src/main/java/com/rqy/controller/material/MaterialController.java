package com.rqy.controller.material;

import com.github.pagehelper.PageInfo;
import com.rqy.domain.Material;
import com.rqy.domain.MaterialExample;
import com.rqy.domain.MaterialReceive;
import com.rqy.domain.MaterialReceiveExample;
import com.rqy.service.material.MaterialService;
import com.rqy.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("material")
public class MaterialController {
    @Autowired
    MaterialService materialService;

    @RequestMapping("find")
    public String find(){
        return "material_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public PageBean<Material> list(int page, int rows){
        List<Material> materials= materialService.findAllMaterial(page, rows);
        PageInfo<Material> pageInfo = new PageInfo<>(materials);
        PageBean<Material> pageBean = new PageBean<>(materials, pageInfo.getTotal());
        return pageBean;
    }
    @RequestMapping("get/{id}")
    @ResponseBody
    public Material list(@PathVariable String id){
        Material material = materialService.selectByPrimaryKey(id);
        return material;
    }

    //修改前的判断
    @RequestMapping("edit_judge")
    @ResponseBody
    public Map edit_judge(){
        HashMap<String, Object> map = new HashMap<>();
        return map;
    }
    //只进行备注修改操作
    @RequestMapping("update_note")
    @ResponseBody
    public Map update_note(Material material){
        int i = materialService.updateByPrimaryKeySelective(material);
        HashMap<String, Object> map = new HashMap<>();
        if(i == 1){
            map.put("status","200");
        }else {
            map.put("status","302");
        }
        return map;
    }
    //编辑前先加载edit页面
    @RequestMapping("edit")
    public String edit(){
        return "material_edit";
    }
    //编辑后提交操作
    @RequestMapping("update_all")
    @ResponseBody
    public Map update_all(Material material){
        int i = materialService.updateByPrimaryKey(material);
        HashMap<String, Object> map = new HashMap<>();
        if(i == 1){
            map.put("status","200");
        }else {
            map.put("status","302");
        }
        return map;
    }

    //删除前的判断
    @RequestMapping("delete_judge")
    @ResponseBody
    public Map delete_judge(){
        HashMap<String, Object> map = new HashMap<>();
        return map;
    }
    //可选择（一个或多个，故用deleteByExample方法）删除操作
    @RequestMapping("delete_batch")
    @ResponseBody
    public Map delete_batch(String ids){
        MaterialExample example = new MaterialExample();
        //将ids字符串转化为数组
        String[] split = ids.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(split));
        example.createCriteria().andMaterialIdIn(list);
        int i = materialService.deleteByExample(example);
        HashMap<String, Object> map = new HashMap<>();
        if(i != 0){
            map.put("status","200");
        }else{
            map.put("status","302");
        }
        return map;
    }

    //新增前的判断
    @RequestMapping("add_judge")
    @ResponseBody
    public Map add_judge(){
        HashMap<String, Object> map = new HashMap<>();
        return map;
    }
    //点击新增后加载add页面
    @RequestMapping("add")
    public String add(){
        return "material_add";
    }
    //新增操作
    @RequestMapping("insert")
    @ResponseBody
    public Map insert(Material material){
        int insert = materialService.insert(material);
        HashMap<String, Object> map = new HashMap<>();
        if(insert != 0){
            map.put("status","200");
        } else {
            map.put("status","302");
        }
        return map;
    }

    /**
     * 模糊查询
     * 通过id或name查询
     * */
    @RequestMapping("search_material_by_materialId")
    @ResponseBody
    public PageBean<Material> search_material_by_materialId(int page, int rows,String searchValue){
        MaterialExample example = new MaterialExample();
        example.createCriteria().andMaterialIdLike("%" + searchValue + "%");
        List<Material> materials = materialService.findAllMaterialByIdOrName(page,rows,example);
        PageInfo<Material> pageInfo = new PageInfo<>(materials);
        PageBean<Material> pageBean = new PageBean<>(materials, pageInfo.getTotal());
        return pageBean;
    }
    @RequestMapping("search_material_by_materialType")
    @ResponseBody
    public PageBean<Material> search_material_by_materialType(int page, int rows,String searchValue){
        MaterialExample example = new MaterialExample();
        example.createCriteria().andMaterialTypeLike("%" + searchValue + "%");
        List<Material> materials = materialService.findAllMaterialByIdOrName(page,rows,example);
        PageInfo<Material> pageInfo = new PageInfo<>(materials);
        PageBean<Material> pageBean = new PageBean<>(materials, pageInfo.getTotal());
        return pageBean;
    }

    //materialReceive新增里面物料id需要对应material表
    @RequestMapping("get_data")
    @ResponseBody
    public List<Material> get_data(){
        MaterialExample example = new MaterialExample();
        List<Material> materials = materialService.selectByExample(example);
        return materials;
    }
}
