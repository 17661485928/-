package com.coffee.kafeisummary.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.coffee.kafeisummary.dao.LoginDao;
import com.coffee.kafeisummary.pojo.SysUserPojo;
import com.coffee.kafeisummary.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kafei
 * @Title: LoginServiceImpl
 * @Package
 * @Description: 用户登录注册接口实现模块
 * @date 2020/6/22 17:35
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;
    /**
     *  用户登录接口
     * @param requestJson
     * @return
     */
    @Override
    public Map<String,Object> login(String requestJson) {
        Map<String,Object> responseMaps = new HashMap<>(4);
        Map<String,Object> requestMaps = JSONObject.parseObject(requestJson);
        String username = requestMaps.get("username").toString();
        SysUserPojo sysUserPojo = loginDao.login(username);
        if(sysUserPojo==null){
            responseMaps.put("code",201);
            responseMaps.put("msg","用户不存在！");
            return responseMaps;
        }
        if(!sysUserPojo.getPassword().equals(requestMaps.get("password").toString())){
            responseMaps.put("code",201);
            responseMaps.put("msg","用户密码不正确！");
            return responseMaps;
        }
        responseMaps.put("code",200);
        responseMaps.put("msg","登录成功!");
        responseMaps.put("data",sysUserPojo);
        return  responseMaps;
    }
}
