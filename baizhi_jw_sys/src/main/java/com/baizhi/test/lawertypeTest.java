package com.baizhi.test;

import com.baizhi.entity.Lawertype;
import com.baizhi.service.LawertypeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2017/6/13.
 */
public class lawertypeTest {
    public static void main(String[] args) {
        ApplicationContext c = new ClassPathXmlApplicationContext("spring-basic.xml");
        LawertypeService ls =(LawertypeService) c.getBean("lawertypeService");
        List<Lawertype> lawertypes = ls.queryAllBylawerid("2");
        System.out.println(lawertypes);
    }
}
