package com.baizhi.controller;

import com.baizhi.entity.Lawertype;
import com.baizhi.service.LawertypeService;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/12.
 */
@Controller
@RequestMapping("/lawertype")
public class LawertypeController {
    @Resource
    private LawertypeService lawertypeService;
    @RequestMapping("/showAll")
    @ResponseBody
    public List<Lawertype> showAll(){
        List<Lawertype> lawertypes = lawertypeService.queryAll();
        return lawertypes;
    }

    @RequestMapping("/showAllByPage")
    @ResponseBody
    public Map<String, Object> showAll(int page,int rows) throws Exception{
        Page<Lawertype> lawertypes = lawertypeService.queryAll(page,rows);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("rows",lawertypes.getResult());
        map.put("total",lawertypes.getTotal());
        return map;
    }
    @RequestMapping("/add")
    public void add(Lawertype l){
        lawertypeService.add(l);
    }
    @RequestMapping("/delete")
    public void delete(String id){
        lawertypeService.delete(id);
    }
    @RequestMapping("/update")
    public void update(Lawertype l){
        lawertypeService.update(l);
    }
    @RequestMapping("/showOne")
    @ResponseBody
    public Lawertype showOne(String id){
        Lawertype lawertype = lawertypeService.queryOne(id);
        return lawertype;
    }
    @RequestMapping("/showAllBylawerid")
    @ResponseBody
    public List<Lawertype> showAllBylawerid(String id){
        List<Lawertype> lawertypes = lawertypeService.queryAllBylawerid(id);
        return lawertypes;
    }
}
