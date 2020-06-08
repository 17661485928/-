package com.kafei.usercoffee.service;

import com.kafei.usercoffee.model.Permission;
import com.kafei.usercoffee.model.Role;
import com.kafei.usercoffee.model.User;

import java.util.List;
import java.util.Map;

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

    void userRegister(Map<String, Object> params);

    Map<String,Object> roleInfoList(String page, String limit);

    Map<String, Object> delRole(String id);

    Map<String, Object> addRoleInfo(String rolename, String des);

    Map<String, Object> editRoleInfo(String id, String rolename, String des);

    Map<String, Object> permInfoList(String page, String limit);

    Map<String, Object> userInfoList(String page, String limit);

    Map<String, Object> addUserInfo(Map<String, Object> params);

    Map<String, Object> addPermInfo(String url, String permName, String permTag);

    Map<String, Object> delPerm(String id);

    Map<String, Object> editPermInfo(String id, String url, String permName, String permTag);

    Map<String, Object> roleAuthorization(String id, String roleId);

    Map<String, Object> roleToUser(String id, String ids);

    Map<String, Object> userAllroleInfoList(String userId,String page, String limit);

    Map<String, Object> roleAllPermInfoList(String roleId, String page, String limit);

    Map<String, Object> delUser(String userIds);
}
