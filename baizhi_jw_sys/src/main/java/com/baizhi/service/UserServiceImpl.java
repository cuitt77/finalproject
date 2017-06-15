package com.baizhi.service;

import com.baizhi.dao.UserMapper;
import com.baizhi.entity.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/6/13.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    public Page<User> queryAll(int pageNum, int pageSize) {
        Page<User> page = PageHelper.startPage(pageNum, pageSize);
        userMapper.selectAll();
        return page;
    }

    public User queryAllByuserid(String id) {
        User user = userMapper.selectfavLawer(id);
        return user;
    }


}
