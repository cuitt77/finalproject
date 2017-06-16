package com.baizhi.service;

import com.baizhi.entity.Comment;
import com.baizhi.entity.Order;

import java.util.List;

/**
 * Created by Administrator on 2017/6/15.
 */
public interface OrderService
{
    //添加订单
    public void addOrder(Order o);
    //修改订单状态
    public void updateOrderstatus(int status,String id);
    //添加评价
    public void addCom(Comment c);
    //查看所有订单
    public List<Order> queryAllByUserid(String id);
}
