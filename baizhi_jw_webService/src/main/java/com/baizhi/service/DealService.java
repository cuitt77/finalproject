package com.baizhi.service;

import com.baizhi.entity.Deal;
import com.baizhi.entity.Dealtype;

import java.util.List;

/**
 * Created by Administrator on 2017/6/15.
 */
public interface DealService {
    //展示案例的一级类别
    public List<Dealtype> queryAllOne();
    //根据一级类别id查所有二级类别 以及一级类别下的案例
    public List<Dealtype> querAllTwo(String id);
    //根据二级类别id展示该二级类别的所有案例
    public List<Deal> queryAllDeal(String id);
    //根据案例id查案例
    public Deal queryOneDeal(String id);
}
