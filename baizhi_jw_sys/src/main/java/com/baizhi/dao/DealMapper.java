package com.baizhi.dao;

import com.baizhi.entity.Deal;

import java.util.List;

public interface DealMapper {
    int deleteByPrimaryKey(String id);

    int insert(Deal record);

    Deal selectByPrimaryKey(String id);

    int updateByPrimaryKey(Deal record);
    //查所有案例及所属二级分类名称
    List<Deal> selectAll();

}