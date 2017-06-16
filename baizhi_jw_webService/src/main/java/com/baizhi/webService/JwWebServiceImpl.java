package com.baizhi.webService;

import com.baizhi.entity.*;
import com.baizhi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.jws.WebService;
import javax.ws.rs.*;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/6/15.
 */
@WebService
@Path("/jw")
public class JwWebServiceImpl implements JwWebService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private LawerService lawerService;
    @Autowired
    private UserService userService;
    @Autowired
    private DealService dealService;
    @Autowired
    private RedpackageService redpackageService;
    @Autowired
    private LawertypeService lawertypeService;
    @Autowired
    private OrderService orderService;
    //查所有律师
    @Path("/showAllLawer")
    @GET
    @Produces("application/json;charset=utf-8")
    public HashMap<String,Object> showAllLawer() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            List<Lawer> lawers = lawerService.queryAll();
            map.put("status",1);
            map.put("success",lawers);
        } catch (Exception e) {
            map.put("status",0);
            e.printStackTrace();
        }
        return map;
    }
    //查一个律师详细信息
    @GET
    @Path("/showOneLawer/{id}")
    @Produces("application/json;charset=utf-8")
    public HashMap<String,Object> showOneLawer(@PathParam("id") String id) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            Lawer lawer = lawerService.queryOne(id);
            map.put("status",1);
            map.put("success",lawer);
        } catch (Exception e) {
            map.put("status",0);
            e.printStackTrace();
        }
        return map;
    }

    //添加用户
    @Path("/addUser")
    @POST
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public HashMap<String, Object> addUser(String phone, String code) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        ValueOperations operations = redisTemplate.opsForValue();
        String s = (String)operations.get(phone);
        if(s.equalsIgnoreCase(code)){
            try {
                User u= userService.add(phone);
                map.put("success",u);
                map.put("status",1);
            } catch (Exception e) {
                e.printStackTrace();
                map.put("status",0);
            }
        }else {
            map.put("status",0);
        }
        return map;
    }
    //手机验证码
    @Path("/check/{phone}")
    @GET
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public HashMap<String, Object> check(@PathParam("phone") String phone) {
        ValueOperations operations = redisTemplate.opsForValue();

        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            String check = userService.check(phone);
            operations.set(phone,check);
            redisTemplate.expire(phone,120, TimeUnit.SECONDS);
            map.put("status",1);
        } catch (Exception e) {
            map.put("status",0);
            e.printStackTrace();
        }
        return map;
    }
    //根据id查一个用户
    @Path("/showOneUser/{id}")
    @GET
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public HashMap<String, Object> showOneUser(@PathParam("id") String id) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            User user = userService.queryOne(id);
            map.put("status",1);
            map.put("success",user);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",0);
        }
        return map;
    }
    //查看收藏
    @Path("/showfav/{id}")
    @GET
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public HashMap<String, Object> showfav(@PathParam("id") String id) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            User fav = userService.queryfav(id);
            map.put("status",1);
            map.put("success",fav);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",0);
        }
        return map;
    }
    //添加收藏
    @Path("/insertfav/{userid}/{lawerid}")
    @GET
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public HashMap<String, Object> insertfav(@PathParam("userid") String userid,@PathParam("lawerid") String lawerid) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            userService.addfav(userid,lawerid);
            map.put("status",1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",0);
        }
        return map;
    }
    //取消收藏
    @Path("/delfav")
    @DELETE
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public HashMap<String, Object> delfav(String userid, String lawerid) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            userService.delfav(userid,lawerid);
            map.put("status",1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",0);
        }
        return map;
    }

    //查所有一级分类
//添加收藏
    @Path("/queryAllOneDealtype")
    @GET
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public HashMap<String, Object> queryAllOneDealtype() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            List<Dealtype> dealtypes = dealService.queryAllOne();
            map.put("status",1);
            map.put("success",dealtypes);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",0);
        }
        return map;
    }
    //根据一级id查二级分类一级案例
    @Path("/querAllTwoDealtype/{id}")
    @GET
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public HashMap<String, Object> querAllTwoDealtype(@PathParam("id") String id) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            List<Dealtype> dealtypes = dealService.querAllTwo(id);
            map.put("status",1);
            map.put("success",dealtypes);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",0);
        }
        return map;
    }
    //根据二级id查所有案例
    @Path("/queryAllDealByDealtypeid/{id}")
    @GET
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public HashMap<String, Object> queryAllDealByDealtypeid(@PathParam("id") String id) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            List<Deal> deals = dealService.queryAllDeal(id);
            map.put("status",1);
            map.put("success",deals);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",0);
        }
        return map;
    }
    //根据案例id查案例、
    @Path("/queryOneDeal/{id}")
    @GET
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public HashMap<String, Object> queryOneDeal(@PathParam("id") String id) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            Deal deal = dealService.queryOneDeal(id);
            map.put("status",1);
            map.put("success",deal);
        } catch (Exception e) {
            map.put("status",0);
        }
        return map;
    }
    //添加红包
    @Path("/addred")
    @POST
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public HashMap<String, Object> addred(Redpackage r) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            redpackageService.insertred(r);
            map.put("status",1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",0);
        }
        return null;
    }
    //查所有律师分类
    @Path("/queryAllLawertype")
    @GET
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public HashMap<String, Object> queryAllLawertype() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            List<Lawertype> lawertypes = lawertypeService.queryAll();
            map.put("status",1);
            map.put("success",lawertypes);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",0);
        }
        return map;
    }
    //根据律师分类查律师
    @Path("/queryAllLawerByLawertype/{id}")
    @GET
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public HashMap<String, Object> queryAllLawerByLawertype(@PathParam("id") String id) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            Lawertype lawertype = lawertypeService.queryAllLawer(id);
            map.put("status",1);
            map.put("success",lawertype);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",0);
        }
        return map;
    }
    //添加订单
    @Path("/addOrder")
    @POST
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public HashMap<String, Object> addOrder(Order o) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            orderService.addOrder(o);
            map.put("status",1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",0);
        }
        return map;
    }
    //更新订单状态
    @Path("/updateOrder")
    @PUT
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public HashMap<String, Object> updateOrder(int status, String id) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            orderService.updateOrderstatus(status,id);
            map.put("status",1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",0);

        }
        return map;
    }
    //根据用户id查订单
    @Path("/showAllOrder/{id}")
    @GET
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public HashMap<String, Object> showAllOrder(@PathParam("id") String id) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            List<Order> orders = orderService.queryAllByUserid(id);
            map.put("status",1);
            map.put("success",orders);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",0);
        }
        return map;
    }
    //添加评价
    @Path("/addCom")
    @POST
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public HashMap<String, Object> addCom(Comment c) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            orderService.addCom(c);
            map.put("status",1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",0);
        }
        return map;
    }
}
