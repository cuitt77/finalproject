package com.baizhi.dao;

import com.baizhi.entity.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKey(User record);

    List<User> selectAll();
    //查看用户收藏的律师
    User selectfavLawer(String id);

}