package com.baizhi.service;

import com.baizhi.entity.Lawer;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * Created by Administrator on 2017/6/12.
 */
public interface LawerServcie {
    //查所有
    public Page<Lawer> queryAll(int pageNum, int pageSize);
    //查一个
    public Lawer queryOne(String id);
    //修改律师信息
    public void update(Lawer l);
    //增加
    public void add(Lawer l);
    //删除
    public void delete(String id);
    //根据分类id查律师
    public List<Lawer> queryAllBylawertypeid(String id);
}
