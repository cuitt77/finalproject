package com.baizhi.service;

import com.baizhi.dao.CommentMapper;
import com.baizhi.dao.OrderMapper;
import com.baizhi.entity.Comment;
import com.baizhi.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/6/16.
 */
@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private CommentMapper commentMapper;
    public void addOrder(Order o) {
        o.setId(UUID.randomUUID().toString());
        o.setStatus(1);
        orderMapper.insert(o);
    }

    public void updateOrderstatus(int status,String id) {
        orderMapper.updateOrder(status,id);
    }

    public void addCom(Comment c) {
        commentMapper.insert(c);
    }

    public List<Order> queryAllByUserid(String id) {
        List<Order> orders = orderMapper.selectAllByuserid(id);
        return orders;
    }
}
