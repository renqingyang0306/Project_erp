package com.rqy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 任清阳
 * @Email 1277409109@qq.com
 * @date 2019/8/11 21:46
 */
@Controller
public class UploadController {
    @Autowired
    ServletContext context;
    //上传图片
    @RequestMapping("pic/upload")
    @ResponseBody
    public  Map<String,Object>  uploadPic(MultipartFile uploadFile) {
        //获取本项目的资源路径
        String realPath = context.getRealPath("/WEB-INF/pic");
        //上传路径，文件名
        File receive=new File(realPath,uploadFile.getOriginalFilename());
        //io上传
        Map<String,Object> map=new HashMap<>();
        try {
            uploadFile.transferTo(receive);
            //返回页面想要的json数据
            map.put("error",0);
            map.put("url","/pic/"+uploadFile.getOriginalFilename());
        } catch (IOException e) {
            map.put("error",1);
        }
        return map;
    }
    //删除图片
    @RequestMapping("pic/delete")
    @ResponseBody
    public  Map<String,Object>  deleteUploadPic(String picName) {
        //获取本项目的资源路径
        String realPath = context.getRealPath("/WEB-INF/pic");
       //删除文件路径
        File receive=new File(realPath,picName);
        //io上传
        Map<String,Object> map=new HashMap<>();
        receive.delete();
        //返回页面想要的json数据
        map.put("data","success");
        return map;
    }
    //上传文件
    @RequestMapping("file/upload")
    @ResponseBody
    public  Map<String,Object>  uploadFile(MultipartFile file) {
        //上传本地路径，文件名
        File receive=new File("D://file",file.getOriginalFilename());
        //io上传
        Map<String,Object> map=new HashMap<>();
        try {
            file.transferTo(receive);
            //返回页面想要的json数据
            map.put("error",0);
            map.put("url","/file/D:file\\"+file.getOriginalFilename());
        } catch (IOException e) {
            map.put("error",1);
        }
        return map;
    }
    //删除文件
    @RequestMapping("file/delete")
    @ResponseBody
    public  Map<String,Object>  deleteUploadFile(String fileName) {
        //删除本地路径，文件名
        File receive=new File("D://file",fileName);
        //io上传
        Map<String,Object> map=new HashMap<>();
        receive.delete();
        //返回页面想要的json数据
        map.put("data","success");
        return map;
    }
}
