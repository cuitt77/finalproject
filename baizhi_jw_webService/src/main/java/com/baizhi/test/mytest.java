package com.baizhi.test;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Lawer;
import com.baizhi.entity.Redpackage;
import com.baizhi.entity.User;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.StringEntity;
import org.junit.Test;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by Administrator on 2017/6/16.
 */
public class mytest {
    @Test
    public void testSelectAll() throws Exception {

        String s = Request.Get("http://localhost:8989/baizhi_jw_webService/service/jw/jw/showAllLawer")
                .execute().returnContent().asString(Charset.forName("UTF-8"));
        System.out.println("第一次拿到的"+s);
        //拿到jsonobject
        JSONObject jo = JSONObject.parseObject(s);
        Object o = jo.get("success");

        System.out.println("转对象"+o);
        //为集合
        List<Lawer> lawers = JSONObject.parseArray(o.toString(), Lawer.class);
        for (Lawer lawer : lawers) {
            System.out.println("律师们        "+lawer);
        }

    }

    @Test
    public void insertRed() throws Exception {
        Redpackage red = new Redpackage(null,new BigDecimal(10),"aaaaaaaaaaaaaaaaaa");
        Lawer l = new Lawer();
        l.setId("2");
        red.setLawer(l);
        User user = new User();
        user.setId("1");
        red.setUser(user);
        String ss = JSONObject.toJSONString(red);

       Request.Post("http://localhost:8989/baizhi_jw_webService/service/jw/jw/addred").
                body(new StringEntity(ss, "utf-8")).setHeader("content-type","application/json;charset=utf-8").execute();
    }

}
