package com.baizhi.test;

import com.baizhi.service.DealtypeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/6/14.
 */
public class dealtypeTest {
    public static void main(String[] args) {
        ApplicationContext c = new ClassPathXmlApplicationContext("spring-basic.xml");
        DealtypeService ds =(DealtypeService) c.getBean("dealtypeService");

    }


}
