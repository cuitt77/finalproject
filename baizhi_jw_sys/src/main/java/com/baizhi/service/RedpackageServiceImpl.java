package com.baizhi.service;

import com.baizhi.dao.RedpackageMapper;
import com.baizhi.entity.Redpackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/6/13.
 */
@Service("redpackageService")
@Transactional
public class RedpackageServiceImpl implements RedpackageService {
    @Autowired
    private RedpackageMapper redpackageMapper;
    public List<Redpackage> queryAllBylawerid(String id) {
        List<Redpackage> redpackages = redpackageMapper.selectBylawerid(id);
        return redpackages;
    }
    public List<Redpackage> queryAllByuserid(String id) {
        List<Redpackage> redpackages = redpackageMapper.selectByuserid(id);
        return redpackages;
    }
}
