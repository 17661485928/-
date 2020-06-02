package com.kafei.usercoffee.service;

import com.kafei.usermodules.model.Permission;
import com.kafei.usermodules.model.User;

import java.util.List;

/**
 * @author kafei
 * @Title: UserModulesService
 * @Package com.kafei.usermodules.service.impl
 * @Description: 用户相关操作业务处理接口层
 * @date 2020/5/27 17:14
 */
public interface UserService {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public User queryUserInformationByUserName(String username);

    /**
     * 根据用户名查询用户权限信息
     * @param username
     * @return
     */
    public List<Permission> queryUserPermissionByUserName(String username);
}
