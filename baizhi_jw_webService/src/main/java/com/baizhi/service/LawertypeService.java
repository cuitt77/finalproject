package com.baizhi.service;

import com.baizhi.entity.Lawertype;

import java.util.List;

/**
 * Created by Administrator on 2017/6/15.
 */
public interface LawertypeService {
    //查所有分类
    public List<Lawertype> queryAll();
    //查看该分类下所有律师
    public Lawertype queryAllLawer(String id);
}
