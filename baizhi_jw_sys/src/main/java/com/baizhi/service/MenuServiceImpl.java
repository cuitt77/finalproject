package com.baizhi.service;

import com.baizhi.dao.MenuMapper;
import com.baizhi.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/6/11.
 */
@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService {
    //查所有
    @Autowired
    private MenuMapper menuMapper;
    public List<Menu> queryAll() {
        List<Menu> menus = menuMapper.selectAll();
        return menus;
    }
}
