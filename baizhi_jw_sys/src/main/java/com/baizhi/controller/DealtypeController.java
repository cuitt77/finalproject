package com.baizhi.controller;

import com.baizhi.entity.Dealtype;
import com.baizhi.service.DealtypeService;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/14.
 */
@Controller
@RequestMapping("/dealtype")
public class DealtypeController {
    @Resource
    private DealtypeService dealtypeService;
    @RequestMapping("/showAllByPage")
    @ResponseBody
    public Map<String, Object> showAllByPage(int page, int rows) throws Exception{
        Page<Dealtype> deals = dealtypeService.queryAllone(page,rows);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("rows",deals.getResult());
        map.put("total",deals.getTotal());
        return map;
    }
    @RequestMapping("/showAll")
    @ResponseBody
    public List<Dealtype> showAll() throws Exception{
        List<Dealtype> dealtypes = dealtypeService.queryAll();
        return dealtypes;
    }
    //根据一级id的所有二级
    @RequestMapping("/showAlltwobyone")
    @ResponseBody
    public List<Dealtype> showAlltwobyone(String id){
        Dealtype dealtype = dealtypeService.queryAllByoneid(id);
        List<Dealtype> dealtypes = dealtype.getDealtypes();
        return dealtypes;

    }
    //添加一级分类
    @RequestMapping("/addOne")
    public void addOne(Dealtype d){
        System.out.println(d);
        dealtypeService.addOne(d);
    }
    //添加二级分类
    @RequestMapping("/addTwo")
    public void addTwo(Dealtype d,String tid){
        Dealtype one = new Dealtype();
        one.setId(tid);
        d.setDealtype(one);
        dealtypeService.addTwo(d);
    }
    //更新
    @RequestMapping("/update")
    public void update(Dealtype d){
        System.out.println(d);
        dealtypeService.update(d);
    }
    //查一个
    @RequestMapping("/showOne")
    @ResponseBody
    public Dealtype showOne(String id){
        Dealtype dealtype = dealtypeService.queryOne(id);
        return dealtype;
    }


}
