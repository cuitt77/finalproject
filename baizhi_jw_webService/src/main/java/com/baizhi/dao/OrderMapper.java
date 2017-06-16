package com.baizhi.dao;

import com.baizhi.entity.Comment;
import com.baizhi.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(String id);
    //添加订单
    int insert(Order record);

    Order selectByPrimaryKey(String id);

    int updateByPrimaryKey(Order record);
    //根据用户id查所有订单 一级评价
    List<Order> selectAllByuserid(String id);
    //查询所有订单
    List<Order> selectAll();
    //添加评论
    int insertCom(Comment c);
    //修改订单状态
    int updateOrder(@Param("status") int status,@Param("id") String id);
}