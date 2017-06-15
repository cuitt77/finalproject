package com.baizhi.controller;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/6/11.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Resource
    private MenuService menuService;
    @RequestMapping("/showAll")
    @ResponseBody
    public List<Menu> selectAll(){
        List<Menu> menus = menuService.queryAll();
        return menus;
    }
}
