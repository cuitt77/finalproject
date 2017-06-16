package com.baizhi.service;

import com.baizhi.dao.LawerMapper;
import com.baizhi.dao.LawertypeMapper;
import com.baizhi.entity.Lawer;
import com.baizhi.entity.Lawertype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/6/15.
 */
@Service("lawertypeService")
@Transactional
public class LawertypeServiceImpl implements LawertypeService {
    @Autowired
    private LawertypeMapper lawertypeMapper;
    @Autowired
    private LawerMapper lawerMapper;
    public List<Lawertype> queryAll() {
        List<Lawertype> lawertypes = lawertypeMapper.selectAll();
        return lawertypes;
    }

    public Lawertype queryAllLawer(String id) {
        List<Lawer> lawers = lawerMapper.selectAllBylawertypeid(id);
        Lawertype lawertype = lawertypeMapper.selectByPrimaryKey(id);
        lawertype.setLawers(lawers);
        return lawertype;
    }
}
