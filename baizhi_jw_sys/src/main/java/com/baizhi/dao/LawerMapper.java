package com.baizhi.dao;

import com.baizhi.entity.Lawer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LawerMapper {
    int deleteByPrimaryKey(String id);

    int insert(Lawer record);

    Lawer selectByPrimaryKey(String id);

    List<Lawer> selectAll();

    int updateByPrimaryKey(Lawer record);
    //添加关系
    int inserttype(@Param("lawerid") String lawerid,@Param("lawertypeid") String lawertypeid);
    //根据律师id删除关系
    int deletetype(String lawerid);
    //根据分类id删除关系
    int deletetype1(String lawertypeid);
    //根据类别id查律师
    List<Lawer> selectAllBylawertypeid(String id);
}