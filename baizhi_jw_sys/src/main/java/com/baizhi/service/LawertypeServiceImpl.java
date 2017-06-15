package com.baizhi.service;

import com.baizhi.dao.LawerMapper;
import com.baizhi.dao.LawertypeMapper;
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
@Service("lawertypeService")
@Transactional
public class LawertypeServiceImpl implements LawertypeService {
    @Autowired
    private LawertypeMapper lawertypeMapper;
    @Autowired
    private LawerMapper lawermapper;
    public Page<Lawertype> queryAll(int pageNum, int pageSize) {
        Page<Lawertype> page = PageHelper.startPage(pageNum, pageSize);
        lawertypeMapper.selectAll();
        return page;
    }

    public List<Lawertype> queryAll() {
        List<Lawertype> lawertypes = lawertypeMapper.selectAll();
        return lawertypes;
    }

    //查一个有详细律师信息
    public Lawertype queryOne(String id) {
        Lawertype lawertype = lawertypeMapper.selectByPrimaryKey(id);
        return lawertype;
    }

    public void add(Lawertype lt) {
        lt.setId(UUID.randomUUID().toString());
    lawertypeMapper.insert(lt);
    }

    public void delete(String id) {
    //删除该分类下的律师关系
        lawermapper.deletetype1(id);
        //删除律师分类
        lawertypeMapper.deleteByPrimaryKey(id);

    }

    public void update(Lawertype lt) {
        //更新分类
        lawertypeMapper.updateByPrimaryKey(lt);


    }

    public List<Lawertype> queryAllBylawerid(String id) {
        List<Lawertype> lawertypes = lawertypeMapper.selectAllBylawerid(id);
        return lawertypes;
    }
}
