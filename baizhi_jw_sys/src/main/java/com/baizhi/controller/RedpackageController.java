package com.baizhi.controller;

import com.baizhi.entity.Redpackage;
import com.baizhi.service.RedpackageService;
import com.baizhi.vo.bigjava;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/13.
 */
@Controller
@RequestMapping("/redpackage")
public class RedpackageController {
    @Resource
    private RedpackageService redpackageService;
    @RequestMapping("/showAllBylawerid")
    @ResponseBody
    public List<bigjava> showAllBylawerid(String id){
        //新建一个list
        ArrayList<bigjava> showjsons = new ArrayList<bigjava>();
        //根据律师id查红包list
        List<Redpackage> redpackages = redpackageService.queryAllBylawerid(id);
        //遍历红包list
        for(Redpackage r:redpackages){
            //新建大java类对象
            bigjava sj = new bigjava();
            //set进去
            sj.setLawername(r.getLawer().getName());
            sj.setRedid(r.getId());
            sj.setRedcontent(r.getContent());
            sj.setRedpackage(r.getContent());
            sj.setUsername(r.getUser().getName());
            //集合添加对象
            showjsons.add(sj);
        }
        return showjsons;
    }
    @RequestMapping("showAllByuserid")
    @ResponseBody
    public List<bigjava> showAllByuserid(String id){
        ArrayList<bigjava> sjlist = new ArrayList<bigjava>();
        List<Redpackage> redpackages = redpackageService.queryAllByuserid(id);
        for(Redpackage r:redpackages){
            bigjava sj=new bigjava();
            sj.setLawername(r.getLawer().getName());
            sj.setRedid(r.getId());
            sj.setRedcontent(r.getContent());
            sj.setRedpackage(r.getContent());
            sj.setUsername(r.getUser().getName());
            sjlist.add(sj);
        }

        return  sjlist;
    }
}
