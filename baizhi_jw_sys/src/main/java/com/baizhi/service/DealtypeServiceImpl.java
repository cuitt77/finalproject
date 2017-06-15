package com.baizhi.service;

import com.baizhi.dao.DealtypeMapper;
import com.baizhi.entity.Dealtype;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/6/14.
 */
@Service("dealtypeService")
@Transactional
public class DealtypeServiceImpl implements DealtypeService {
    @Autowired
    private DealtypeMapper dealtypeMapper;

    public List<Dealtype> queryAll() {
        List<Dealtype> o = dealtypeMapper.selectAllone("o");
        return o;
    }

    //分页查所有一级标签
    public Page<Dealtype> queryAllone(int pageNum, int pageSize) {
        Page<Dealtype> page = PageHelper.startPage(pageNum, pageSize);
        dealtypeMapper.selectAllone("o");
        return page;
    }
    //根据一级id查所有二级
    public Dealtype queryAllByoneid(String id) {
       Dealtype dealtypes = dealtypeMapper.selecttwoByone(id);
        return dealtypes;
    }
//添加一级分类
    public void addOne(Dealtype d) {
        d.setId(UUID.randomUUID().toString());
        d.setFlag("o");
        dealtypeMapper.insertOne(d);
    }
//添加二级分类
    public void addTwo(Dealtype d) {
        d.setId(UUID.randomUUID().toString());
        d.setFlag("t");
        dealtypeMapper.insertTwo(d);

    }
//更新
    public void update(Dealtype d) {
        dealtypeMapper.updateByPrimaryKey(d);
    }
//查一个
    public Dealtype queryOne(String id) {
        Dealtype dealtype = dealtypeMapper.selectByPrimaryKey(id);
        return dealtype;
    }


}
