package com.baizhi.dao;

import com.baizhi.entity.Dealtype;

import java.util.List;

public interface DealtypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Dealtype record);

    Dealtype selectByPrimaryKey(String id);

    int updateByPrimaryKey(Dealtype record);
   //根据一级分类id查二级分类
    Dealtype selecttwoByone(String id);
    //查所有标签
    List<Dealtype> selectAll();
    //查所有一级标签
    List<Dealtype> selectAllone(String flag);
    //添加一级分类
    int insertOne(Dealtype d);
    //添加二级分类
    int insertTwo(Dealtype d);

}