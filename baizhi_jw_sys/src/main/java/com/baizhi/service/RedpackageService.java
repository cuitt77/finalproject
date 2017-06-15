package com.baizhi.service;

import com.baizhi.entity.Redpackage;

import java.util.List;

/**
 * Created by Administrator on 2017/6/13.
 */
public interface RedpackageService {
    public List<Redpackage> queryAllBylawerid(String id);
    public List<Redpackage> queryAllByuserid(String id);
}
