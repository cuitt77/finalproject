package com.baizhi.service;

import com.baizhi.entity.Lawertype;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * Created by Administrator on 2017/6/12.
 */
public interface LawertypeService {
    //查看所有
    public Page<Lawertype> queryAll(int pageNum, int pageSize);
    //查所有
    public List<Lawertype> queryAll();
    //查一个 详细包括律师
    public Lawertype queryOne(String id);
    //增加
    public void add(Lawertype lt);
    //删除
    public void delete(String id);
    //修改
    public void update(Lawertype lt);
    //根据律师id查分类
    public List<Lawertype> queryAllBylawerid(String id);

}
