package com.baizhi.service;

import com.baizhi.entity.User;
import com.github.pagehelper.Page;

/**
 * Created by Administrator on 2017/6/13.
 */
public interface UserService {
    //查所有基本信息
    public Page<User> queryAll(int pageNum, int pageSize);
    //查看收藏的律师
    public User queryAllByuserid(String id);


}
