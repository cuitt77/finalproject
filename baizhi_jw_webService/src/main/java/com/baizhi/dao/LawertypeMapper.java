package com.baizhi.dao;

import com.baizhi.entity.Lawertype;

import java.util.List;

public interface LawertypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Lawertype record);

    Lawertype selectByPrimaryKey(String id);

    int updateByPrimaryKey(Lawertype record);

    List<Lawertype> selectAll();
    //根据律师id查分类
    List<Lawertype> selectAllBylawerid(String id);

}