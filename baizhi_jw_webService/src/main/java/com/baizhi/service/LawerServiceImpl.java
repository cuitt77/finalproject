package com.baizhi.service;

import com.baizhi.dao.CommentMapper;
import com.baizhi.dao.LawerMapper;
import com.baizhi.dao.LawertypeMapper;
import com.baizhi.dao.RedpackageMapper;
import com.baizhi.entity.Comment;
import com.baizhi.entity.Lawer;
import com.baizhi.entity.Lawertype;
import com.baizhi.entity.Redpackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/6/15.
 */
@Service("LawerService")
@Transactional
public class LawerServiceImpl implements LawerService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private RedpackageMapper redpackageMapper;
    @Autowired
    private LawertypeMapper lawertypeMapper;
    @Autowired
    private LawerMapper lawerMapper;

    public List<Lawer> queryAll() {
        List<Lawer> lawers = lawerMapper.selectAll();
        return lawers;
    }

    public Lawer queryOne(String id) {
        Lawer lawer = lawerMapper.selectByPrimaryKey(id);
        List<Lawertype> lawertypes = lawertypeMapper.selectAllBylawerid(id);
        List<Comment> comments = commentMapper.selectAllBylawerid(id);
        List<Redpackage> redpackages = redpackageMapper.selectBylawerid(id);
        lawer.setLawertypes(lawertypes);
        lawer.setComments(comments);
        lawer.setRedpackages(redpackages);
        return lawer;
    }
}
