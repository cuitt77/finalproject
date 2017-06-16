package com.baizhi.service;

import com.baizhi.dao.UserMapper;
import com.baizhi.entity.User;
import com.baizhi.util.MyUtil;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Created by Administrator on 2017/6/15.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    public User add(String phone) {
        User u = userMapper.selectByphone(phone);
        if(u==null){
            User user = new User();
            user.setId(UUID.randomUUID().toString());
            user.setMoney(0.0);
            user.setPhone(phone);
            user.setName("admin");
            userMapper.insert(user);
            return user;
        }else {
            return u;
        }


    }

    public String check(String phone) throws Exception{
        String mysalt = MyUtil.getSalt(5);
        //发送手机验证码
        String url="http://gw.api.taobao.com/router/rest";
        String appkey="23756605";
        String secret="d6eea0f24b74b19928a2d2dd8217418a";
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setExtend("123456");
        req.setSmsType("normal");
        req.setSmsFreeSignName("漂亮的仙女");
        req.setSmsParamString("{\"code\":\""+mysalt+"\"}");
        req.setRecNum(phone);
        req.setSmsTemplateCode("SMS_62315224");
        AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);

        return mysalt;
    }

    public User queryOne(String id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    public User queryfav(String id) {
        User user = userMapper.selectfavLawer(id);
        return user;
    }

    public void addfav(String userid,String lawerid) {
        userMapper.insertfav(userid,lawerid);
    }

    public void delfav(String userid, String lawerid) {
        userMapper.delfav(userid,lawerid);
    }
}
