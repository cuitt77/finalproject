package com.baizhi.dao;

import com.baizhi.entity.Redpackage;

import java.util.List;

public interface RedpackageMapper {
    int deleteByPrimaryKey(String id);

    int insert(Redpackage record);


    Redpackage selectByPrimaryKey(String id);


    int updateByPrimaryKey(Redpackage record);
    //根据律师id查红包
    List<Redpackage> selectBylawerid(String id);
    //根据用户id查红包
    List<Redpackage> selectByuserid(String id);
}