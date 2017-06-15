package com.baizhi.controller;

import com.baizhi.entity.Deal;
import com.baizhi.entity.Dealtype;
import com.baizhi.service.DealService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/14.
 */
@Controller
@RequestMapping("/deal")
public class DealController {
    @Resource
    private DealService dealService;
    @RequestMapping("/showAllByPage")
    @ResponseBody
    public Map<String, Object> showAll(int page, int rows) throws Exception{
        Map<String, Object> map = dealService.queryAll(page, rows);
        return map;
    }
    @RequestMapping("/add")
    public void add(Deal d,String tt){
        System.out.println("id======"+tt);
        Dealtype dealtype = new Dealtype();
        dealtype.setId(tt);
        d.setDealtype(dealtype);
        dealService.add(d);
    }

}
