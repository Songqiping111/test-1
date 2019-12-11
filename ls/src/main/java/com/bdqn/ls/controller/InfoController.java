package com.bdqn.ls.controller;

import com.alibaba.fastjson.JSONObject;
import com.bdqn.ls.pojo.Info;
import com.bdqn.ls.service.InfoService;
import com.bdqn.ls.service.LevelService;
import com.bdqn.ls.service.TypeService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("info")
public class InfoController {
    @Autowired
    private InfoService infoService;
    @Autowired
    private LevelService levelService;
    @Autowired
    private TypeService typeService;
    @RequestMapping("tomain")
    public String tomain(Model model){
        return "main";
    }
    @RequestMapping("tolist")
    public String tolist(Model model){      //进入信息列表页面

        return "list";
    }
    @RequestMapping("toAdd")
    public String toAdd(Model model){       //进入添加信息页面
        model.addAttribute("typeList",typeService.findall());
        model.addAttribute("levelList",levelService.findAll());

        return "addinfo";
    }
    @RequestMapping("doAdd")
    public String doAdd(Info info){         //添加操作
        System.out.println("进来哦了");
        info.setCreatetime(new Date());
        int result=infoService.addInfo(info);
        if(result>0){
            System.out.println("添加成功");
            return "list";
        }else{
            System.out.println("添加失败");
            return "list";
        }

    }

    @PostMapping("upload")   //文件上传
    @ResponseBody
    public JSONObject upload(@RequestParam(value = "file") MultipartFile file,HttpServletRequest request){
        JSONObject res = new JSONObject();
        JSONObject resUrl = new JSONObject();
        String filename = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(file.getOriginalFilename()+"原文件名");
        String ext = FilenameUtils.getExtension(file.getOriginalFilename());
        String filenames = filename + "." + ext;
        System.out.println(filenames+"---new");
        String pathname = "E:\\Git本地仓库\\ls\\src\\main\\resources\\static\\uploadimg\\" + filenames;
        try {
            file.transferTo(new File(pathname));
            resUrl.put("src", pathname);
            res.put("msg", "上传成功");
            res.put("code", 0);
            res.put("data", resUrl);
            return res;
        }catch (IOException e){
            e.printStackTrace();
            resUrl.put("src", pathname);
            res.put("msg", "上传出错");
            res.put("code", 1);
            res.put("data", resUrl);
            return res;
        }


    }
}
