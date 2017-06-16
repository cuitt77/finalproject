package com.baizhi.service;

import com.baizhi.dao.DealMapper;
import com.baizhi.dao.DealtypeMapper;
import com.baizhi.entity.Deal;
import com.baizhi.entity.Dealtype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/6/15.
 */
@Service("dealService")
@Transactional
public class DealServiceImpl implements DealService {
    @Autowired
    private DealMapper dealMapper;
    @Autowired
    private DealtypeMapper dealtypeMapper;
    public List<Dealtype> queryAllOne() {
        List<Dealtype> o = dealtypeMapper.selectAllone("o");
        return o;
    }

    public List<Dealtype> querAllTwo(String id) {
        Dealtype dealtype = dealtypeMapper.selecttwoByone(id);
        List<Dealtype> dealtypes = dealtype.getDealtypes();
        for(Dealtype d:dealtypes){
            List<Deal> deals = dealMapper.selectAllByDealtypid(d.getId());
            d.setDeals(deals);
        }
        return dealtypes;
    }

    public List<Deal> queryAllDeal(String id) {
        List<Deal> deals = dealMapper.selectAllByDealtypid(id);
        return deals;
    }

    public Deal queryOneDeal(String id) {
        Deal deal = dealMapper.selectByPrimaryKey(id);
        return deal;
    }
}
