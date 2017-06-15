package com.baizhi.service;

import com.baizhi.dao.OrderMapper;
import com.baizhi.entity.Order;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/6/13.
 */
@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    public Page<Order> queryAll(int pageNum, int pageSize) {
        Page<Order> page = PageHelper.startPage(pageNum, pageSize);
        orderMapper.selectAll();
        return page;
    }

    public List<Order> queryAllByuserid(String id) {
        List<Order> orders = orderMapper.selectAllByuserid(id);
        return orders;
    }
}
