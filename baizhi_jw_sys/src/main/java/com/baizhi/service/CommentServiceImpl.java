package com.baizhi.service;

import com.baizhi.dao.CommentMapper;
import com.baizhi.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/6/13.
 */
@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    //根据律师id查评价
    public List<Comment> queryAllBylawerid(String id) {
        List<Comment> comments = commentMapper.selectAllBylawerid(id);
        return comments;
    }
}
