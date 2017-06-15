package com.baizhi.controller;

import com.baizhi.entity.Order;
import com.baizhi.service.OrderService;
import com.baizhi.vo.bigjava;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/13.
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    //查所有订单 分页
    @Resource
    private OrderService orderService;
    @RequestMapping("/showAllByPage")
    @ResponseBody
    public Map<String, Object> showAll(int page, int rows) throws Exception{
        Page<Order> o = orderService.queryAll(page,rows);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("rows",o.getResult());
        map.put("total",o.getTotal());
        return map;
    }
    @RequestMapping("/showAllByuserid")
    @ResponseBody
    public List<bigjava> showAllByuserid(String id){
        ArrayList<bigjava> bglist = new ArrayList<bigjava>();

        List<Order> orders = orderService.queryAllByuserid(id);
        for(Order o:orders){
            bigjava bg = new bigjava();
            bg.setOrdercontent(o.getContent());
            bg.setOrderid(o.getId());
            bg.setType(o.getType());
            bg.setStatus(o.getStatus());
            bg.setComcontent(o.getComment().getContent());
            bg.setScore(o.getComment().getScore());
            bglist.add(bg);
        }
        return bglist;
    }
}
