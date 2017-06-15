package com.baizhi.service;

import com.baizhi.dao.LawerMapper;
import com.baizhi.dao.LawertypeMapper;
import com.baizhi.entity.Lawer;
import com.baizhi.entity.Lawertype;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/6/12.
 */
@Service("lawerService")
@Transactional
public class LawerServcieImpl implements LawerServcie {
    @Autowired
    private LawerMapper lawerMapper;
    @Autowired
    private LawertypeMapper lawertypeMapper;
    public Page<Lawer> queryAll(int pageNum, int pageSize) {
        Page<Lawer> page = PageHelper.startPage(pageNum, pageSize);
        lawerMapper.selectAll();
        return page;
    }

    public Lawer queryOne(String id) {
        Lawer lawer = lawerMapper.selectByPrimaryKey(id);
        return lawer;
    }

    public void update(Lawer l) {
        //先删除关系
        lawerMapper.deletetype(l.getId());
        //在更新律师
        lawerMapper.updateByPrimaryKey(l);
        //在添加关系表
        for(Lawertype lt:l.getLawertypes()) {
            lawerMapper.inserttype(l.getId(), lt.getId());
        }
    }

    public void add(Lawer l) {
        l.setId(UUID.randomUUID().toString());
        lawerMapper.insert(l);
        List<Lawertype> lawertypes = l.getLawertypes();
        for(Lawertype lt:lawertypes){
            //添加律师 律师分类关系
            lawerMapper.inserttype(l.getId(),lt.getId());
        }

    }

    public void delete(String id) {
        //先删除关系
        lawerMapper.deletetype(id);
        //在删除律师
        lawerMapper.deleteByPrimaryKey(id);
    }

    public List<Lawer> queryAllBylawertypeid(String id) {
        List<Lawer> lawers = lawerMapper.selectAllBylawertypeid(id);
        return lawers;
    }
}
