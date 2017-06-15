package com.baizhi.dao;

import com.baizhi.entity.Order;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(Order record);

    Order selectByPrimaryKey(String id);

    int updateByPrimaryKey(Order record);
    //根据用户id查所有订单
    List<Order> selectAllByuserid(String id);
    //查询所有订单
    List<Order> selectAll();
}