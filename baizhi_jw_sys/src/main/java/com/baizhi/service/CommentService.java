package com.baizhi.service;

import com.baizhi.entity.Comment;

import java.util.List;

/**
 * Created by Administrator on 2017/6/13.
 */
public interface CommentService {
    //根据律师id查评价
    public List<Comment> queryAllBylawerid(String id);
}
