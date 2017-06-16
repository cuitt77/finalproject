package com.baizhi.service;

import com.baizhi.dao.RedpackageMapper;
import com.baizhi.entity.Redpackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Created by Administrator on 2017/6/15.
 */
@Service("redpackageService")
@Transactional
public class RedpackageServiceImpl implements RedpackageService {
    @Autowired
    private RedpackageMapper redpackageMapper;
    public void insertred(Redpackage r) {
        r.setId(UUID.randomUUID().toString());
        redpackageMapper.insert(r);
        System.out.println("添加");
    }
}
