package com.baizhi.service;

import com.baizhi.entity.Lawer;

import java.util.List;

/**
 * Created by Administrator on 2017/6/15.
 */
public interface LawerService {
    //展示所有律师的基本信息
    public List<Lawer> queryAll();
    //展示一个律师的详细信息 红包 评论 分类
    public Lawer queryOne(String id);
}
