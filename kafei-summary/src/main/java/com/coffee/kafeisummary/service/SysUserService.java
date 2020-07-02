package com.coffee.kafeisummary.service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author kafei
 * @Title: SysUserService
 * @Package com.coffee.kafeisummary.service
 * @Description: 用户信息操作接口
 * @date 2020/6/23 15:42
 */
public interface SysUserService {

    /**
     * 用户信息列表查询接口
     * @param page
     * @param limit
     * @return
     */
    Map<String, Object> sysUserInfoList(String page, String limit,Map<String, Object> requestMaps);

    /**
     * 删除用户信息
     * @param userIds
     * @return
     */
    Map<String, Object> delSysUser(String userIds);

    /**
     * 编辑用户信息
     * @param requestMaps
     * @return
     */
    Map<String, Object> editSysUserInfo(Map<String, Object> requestMaps);

    /**
     * 添加用户信息
     * @param requestMaps
     * @return
     */
    Map<String, Object> addSysUserInfo(Map<String, Object> requestMaps);

    /**
     * 上传用户头像
     * @param request
     * @return
     */
    Map<String, Object> uploadAvatarIcon(HttpServletRequest request);

    Map<String, Object> canceluploadAvatarIcon(String filePtah);
}
