package com.baizhi.test;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2017/6/11.
 */
public class MenuTest {
    public static void main(String[] args) {
        ApplicationContext c = new ClassPathXmlApplicationContext("spring-basic.xml");
        MenuService ms =(MenuService) c.getBean("menuService");
        List<Menu> menus = ms.queryAll();
        for(Menu m:menus){
            System.out.println(m);

        }
    }
}
