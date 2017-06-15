package com.baizhi.service;

import com.baizhi.entity.Dealtype;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */
public interface DealtypeService {
    //查所有一级
    public List<Dealtype> queryAll();
    //查所有一级案例
    public Page<Dealtype> queryAllone(int pageNum, int pageSize);
    //根据一级id查二级
    public Dealtype queryAllByoneid(String id);
    //添加一级分类
    public void addOne(Dealtype d);
    //添加二级分类
    public void addTwo(Dealtype d);
    //更新
    public void update(Dealtype d);
    //查一个
    public Dealtype queryOne(String id);
}
