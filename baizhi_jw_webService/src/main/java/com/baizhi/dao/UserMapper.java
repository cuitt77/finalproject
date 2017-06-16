package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKey(User record);

    List<User> selectAll();
    //查看用户收藏的律师
    User selectfavLawer(String id);
    //根据手机号查看用户
    User selectByphone(String phone);
    //根据用户 律师id添加收藏
    void insertfav(@Param("userid") String userid,@Param("lawerid") String lawerid);
    //根据用户 律师id删除收藏
    void delfav(@Param("userid") String userid,@Param("lawerid") String lawerid);


}