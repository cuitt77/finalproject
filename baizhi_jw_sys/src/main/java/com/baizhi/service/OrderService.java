package com.baizhi.service;

import com.baizhi.entity.Order;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * Created by Administrator on 2017/6/13.
 */
public interface OrderService {
    //分页查所有
    public Page<Order> queryAll(int pageNum, int pageSize);
    //根据用户id查订单
    public List<Order> queryAllByuserid(String id);
}
