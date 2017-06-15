package com.baizhi.controller;

import com.baizhi.entity.Lawer;
import com.baizhi.entity.Lawertype;
import com.baizhi.service.LawerServcie;
import com.baizhi.service.LawertypeService;
import com.github.pagehelper.Page;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/6/12.
 */
@Controller
@RequestMapping("/lawer")
public class LawerController {
    @Resource
    private LawerServcie lawerServcie;
    @Resource
    private LawertypeService lawertypeService;
    //分页查所有
    @RequestMapping("/showAll")
    @ResponseBody
    public Map<String, Object> showAll(int page,int rows) throws Exception{
        Page<Lawer> lawers = lawerServcie.queryAll(page,rows);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("rows",lawers.getResult());
        map.put("total",lawers.getTotal());
        return map;
    }
    //添加
    @RequestMapping("/add")
    public void add(Lawer l, String[] lawertypeid, MultipartFile aaa, HttpServletRequest req){
        System.out.println(aaa.getOriginalFilename());
        String realPath = req.getSession().getServletContext().getRealPath("/");
        File file = new File(realPath + "/lawerphoto");
        if(!file.exists()){
            file.mkdirs();
        }
        //新名字
        String newname=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"."+ FilenameUtils.getExtension(aaa.getOriginalFilename());
        System.out.println("新名字              "+newname);
        try {
            aaa.transferTo(new File(file,newname));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(aaa.getOriginalFilename());
        ArrayList<Lawertype> lawertypes = new ArrayList<Lawertype>();
        for(String id:lawertypeid){
            lawertypes.add(new Lawertype(id,null));
        }
        l.setLawertypes(lawertypes);
        l.setPhoto(newname);
        lawerServcie.add(l);
    }
    //查一个
    @RequestMapping("/showOne")
    @ResponseBody
    public Lawer showOne(String id){
        Lawer lawer = lawerServcie.queryOne(id);
        return lawer;
    }
    //删除
    @RequestMapping("/delete")
    public void delete(String id){
        lawerServcie.delete(id);
    }
    //更新
    @RequestMapping("/update")
    public void update(Lawer l){
        //不更改分类
        List<Lawertype> lawertypes = lawertypeService.queryAllBylawerid(l.getId());
        l.setLawertypes(lawertypes);
        lawerServcie.update(l);
    }
    //更新
    @RequestMapping("/updatetype")
    public void updatetype(String id,String[] lawertypeid){
        System.out.println("=====用户id"+id);
        for(String dd:lawertypeid){
            System.out.println(dd);
        }
        Lawer lawer = lawerServcie.queryOne(id);
        ArrayList<Lawertype> lawertypes = new ArrayList<Lawertype>();
        for(String i:lawertypeid){
            lawertypes.add(new Lawertype(i,null));
        }
        lawer.setLawertypes(lawertypes);

        lawerServcie.update(lawer);
    }
    @RequestMapping("showAllBylawertypeid")
    @ResponseBody
    //根据分类id查律师
    public List<Lawer> showAllBylawertypid(String id){
        List<Lawer> lawers = lawerServcie.queryAllBylawertypeid(id);
        return lawers;
    }

}
