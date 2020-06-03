package com.kafei.usercoffee.dao;

import com.kafei.usercoffee.model.Permission;
import com.kafei.usercoffee.model.User;
import java.util.List;
import java.util.Map;

/**
 * @author kafei
 * @Title: UserModulesDao
 * @Package com.kafei.usermodules.dao
 * @Description: 用户相关操作持久层
 * @date 2020/5/2717:07
 */
public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @return List<UserModel>
     */
    User queryUserInformationByUserName(String username);

    /**
     * 根据用户名查询用户权限信息
     * @param username
     * @return
     */
    List<Permission> queryUserPermissionByUserName(String username);

    /**
     * 查询所有权限
     * @return
     */
    List<Permission> queryAllPermission();

    /**
     * 注册
     * @param params
     */
    void userRegister(Map<String, Object> params);
}
