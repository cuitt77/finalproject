package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/11.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService adminService;
    @RequestMapping("/login")
    @ResponseBody
    public Map<String,Boolean> login(Admin admin){

        HashMap<String,Boolean> map = new HashMap<String,Boolean>();
        try {
            adminService.selectByName(admin);
            map.put("temp",true);
            return map;
        } catch (Exception e) {
            map.put("temp",false);
            e.printStackTrace();
            return map;
        }
    }

}
