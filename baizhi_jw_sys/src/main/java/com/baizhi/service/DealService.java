package com.baizhi.service;

import com.baizhi.entity.Deal;

import java.util.Map;

/**
 * Created by Administrator on 2017/6/14.
 */
public interface DealService {
    //查案例所有
    public Map<String,Object> queryAll(int pageNum, int pageSize);
    //添加
    public void add(Deal d);
}
