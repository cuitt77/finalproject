package com.baizhi.webService;

import com.baizhi.entity.Comment;
import com.baizhi.entity.Order;
import com.baizhi.entity.Redpackage;

import javax.jws.WebService;
import java.util.HashMap;

/**
 * Created by Administrator on 2017/6/15.
 */
@WebService
public interface JwWebService {
    /*
    律师模块
     */
    //查所有律师
    public HashMap<String,Object> showAllLawer();
    //查一个律师详细
    public HashMap<String,Object> showOneLawer(String id);
    /*
    用户模块
     */
    //注册用
    public HashMap<String,Object> addUser(String phone,String code);
    //发送验证码
    public HashMap<String,Object> check(String phone);
    //根据用户id查一个
    public HashMap<String,Object> showOneUser(String id);
    //查看用户收藏
    public HashMap<String,Object> showfav(String id);
    //添加用户收藏
    public HashMap<String,Object> insertfav(String userid,String lawerid);
    //删除收藏 需要一个律师
    public HashMap<String,Object> delfav(String userid,String lawerid);
    /*
    案例模块
     */
    //展示案例的一级类别
    public HashMap<String,Object> queryAllOneDealtype();
    //根据一级类别id查所有二级类别 以及一级类别下的案例
    public HashMap<String,Object> querAllTwoDealtype(String id);
    //根据二级类别id展示该二级类别的所有案例
    public HashMap<String,Object> queryAllDealByDealtypeid(String id);
    //根据案例id查案例
    public HashMap<String,Object> queryOneDeal(String id);
    /*
    心意模块
     */
    //添加心意
    public HashMap<String,Object> addred(Redpackage r);
    /*
    律师分类模块
     */
    //查所有分类
    public HashMap<String,Object> queryAllLawertype();
    //查看该分类下所有律师
    public HashMap<String,Object> queryAllLawerByLawertype(String id);
    /*
    订单模块
     */
    //添加订单
    public HashMap<String,Object> addOrder(Order o);
    //修改订单状态
    public HashMap<String,Object> updateOrder(int status,String id);
    //查看用户 的所有订单
    public HashMap<String,Object> showAllOrder(String id);
    //添加评论
    public HashMap<String,Object> addCom(Comment c);
}
