package com.baizhi.service;

import com.baizhi.dao.DealMapper;
import com.baizhi.entity.Deal;
import com.baizhi.vo.bigjava;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by Administrator on 2017/6/14.
 */
@Service("dealService")
@Transactional
public class DealServiceImpl implements DealService {
    @Autowired
    private DealMapper dealMapper;
    public Map<String,Object> queryAll(int pageNum, int pageSize){

        Map<String, Object> map = new HashMap<String, Object>();
        Page<Deal> page = PageHelper.startPage(pageNum, pageSize);
        dealMapper.selectAll();

        List<bigjava> bgl = new ArrayList<bigjava>();
        for (Deal d : page.getResult()) {
            bigjava bf = new bigjava();
            bf.setDealtypename(d.getDealtype().getName());
            bf.setTitle(d.getTitle());
            bf.setCreatetime(d.getCreatetime());
            bf.setContent(d.getContent());
            bf.setDealid(d.getId());
            bgl.add(bf);
        }
        map.put("rows",bgl);
        map.put("total",page.getTotal());
        return map;
    }

    public void add(Deal d) {
        d.setId(UUID.randomUUID().toString());
        d.setCreatetime(new Date());
        dealMapper.insert(d);
    }
}
