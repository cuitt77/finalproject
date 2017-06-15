package com.baizhi.controller;

import com.baizhi.entity.Lawer;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
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
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("/showAllByPage")
    @ResponseBody
    public Map<String, Object> showAll(int page, int rows) throws Exception{
        Page<User> u = userService.queryAll(page,rows);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("rows",u.getResult());
        map.put("total",u.getTotal());
        return map;
    }
    @RequestMapping("showAllByuserid")
    @ResponseBody
    public List<bigjava> showAllByuserid(String id){
        ArrayList<bigjava> sjlist = new ArrayList<bigjava>();
        User user = userService.queryAllByuserid(id);
        List<Lawer> lawers = user.getLawers();
        for(Lawer r:lawers){
            bigjava sj=new bigjava();
            sj.setUsername(user.getName());
            sj.setLawername(r.getName());
            sj.setAddress(r.getAddress());
            sj.setYear(r.getYear());
            sj.setLawerphone(r.getPhone());
            sj.setNumber(r.getNumber());
            sj.setLawerstatus(r.getStatus());
            sjlist.add(sj);
        }

        return  sjlist;
    }


}
