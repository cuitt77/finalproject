package com.baizhi.dao;

import com.baizhi.entity.Comment;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Comment record);

    Comment selectByPrimaryKey(String id);

    int updateByPrimaryKey(Comment record);
    //根据律师id查订单 和评价 律师表 订单表 评价表
    List<Comment> selectAllBylawerid(String id);
}