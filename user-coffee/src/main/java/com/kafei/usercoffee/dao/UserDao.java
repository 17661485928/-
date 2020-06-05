package com.kafei.usercoffee.dao;

import com.kafei.usercoffee.model.Permission;
import com.kafei.usercoffee.model.Role;
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
     * @return
     */
    Integer userRegister(Map<String, Object> params);

    List<Role> roleInfoList(Map<String,Object> param);

    Integer roleAllCount(Map<String, Object> requestParam);

    Integer delRole(Integer valueOf);

    Integer addRoleInfo(Map<String, Object> requestParam);

    Integer editRoleInfo(Map<String, Object> requestParam);

    List<Permission> permInfoList(Map<String, Object> requestParam);

    Integer permAllCount(Map<String, Object> requestParam);

    List<User> userInfoList(Map<String, Object> requestParam);

    Integer userAllCount(Map<String, Object> requestParam);

    Integer addPermInfo(Map<String, Object> requestParam);

    Integer delPerm(Integer valueOf);

    Integer editPermInfo(Map<String, Object> requestParam);

    Integer roleAuthorization(Map<String, Object> requestParam);
}
