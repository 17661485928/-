package com.kafei.usercoffee.service.impl;

import com.kafei.usercoffee.dao.UserDao;
import com.kafei.usercoffee.model.Permission;
import com.kafei.usercoffee.model.User;
import com.kafei.usercoffee.service.UserService;
import com.kafei.usercoffee.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author kafei
 * @Title: UserModulesServiceImpl
 * @Package com.kafei.usermodules.service.impl
 * @Description: 用户相关操作业务处理接口实现层
 * @date 2020/5/27 17:17
 */
@Service
public class UserServiceImpl implements UserService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserDao userDao;

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    @Override
    public User queryUserInformationByUserName(String username){
       return userDao.queryUserInformationByUserName(username);
    }
    /**
     * 根据用户名查询用户权限信息
     * @param username
     * @return
     */
    @Override
    public List<Permission> queryUserPermissionByUserName(String username){
       return userDao.queryUserPermissionByUserName(username);
    }

    /**
     * @Description: 用户注册
     * @param ${tags}
     * @return ${return_type}
     * @throws
     * @author kafei
     * @date 2020/6/3 11:19
     */
    @Override
    public void userRegister(Map<String, Object> params) {
        String password = MD5Util.encode(params.get("password").toString());
        params.put("password",password);
        params.put("createDate",new Date());
        params.put("lastlogintime",new Date());
        userDao.userRegister(params);
    }
}
