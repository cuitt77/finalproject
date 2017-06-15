package com.baizhi.service;

import com.baizhi.dao.AdminMapper;
import com.baizhi.entity.Admin;
import com.baizhi.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/6/11.
 */
@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    public Admin selectByName(Admin a) {
        String name=a.getAdminname();
        String password = a.getPassword();
        Admin admin = adminMapper.selectByName(name);
        if(admin!=null){
            if(admin.getPassword().equals(MyUtil.getMd5(password+admin.getSalt()))){
                return admin;
            }
            throw new RuntimeException("密码错误");
        }
        throw new RuntimeException("用户不存在");
    }
}
