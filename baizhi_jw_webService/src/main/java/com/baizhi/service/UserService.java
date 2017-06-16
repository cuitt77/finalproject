package com.baizhi.service;

import com.baizhi.entity.User;

/**
 * Created by Administrator on 2017/6/15.
 */
public interface UserService {
    //注册
    public User add(String phone);
    //验证码
    public String check(String phone) throws Exception;
    //查一个用户
    public User queryOne(String id);
    //展示收藏
    public User queryfav(String id);
    //添加收藏 需要一个律师
    public void addfav(String userid,String lawerid);
    //删除收藏 需要一个律师
    public void delfav(String userid,String lawerid);
}
