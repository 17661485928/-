package com.coffee.kafeisummary.controller;

import com.alibaba.fastjson.JSONObject;
import com.coffee.kafeisummary.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kafei
 * @Title: SysUserController
 * @Package com.coffee.kafeisummary.controller
 * @Description: 用户信息操作模块
 * @date 2020/6/23 15:28
 */
@Controller
@RequestMapping(value = "/SysUserController")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;


    /**
     * 用户信息列表查询
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/sysUserInfoList")
    @ResponseBody
    public String sysUserInfoList(HttpServletRequest request) {
        //当前页码
        String page = request.getParameter("page");
        //每页中数据的条数
        String limit = request.getParameter("limit");
        String loginName = request.getParameter("loginName");
        String userName = request.getParameter("userName");
        String phone = request.getParameter("phone");
        String status = request.getParameter("status");
        String delFlag = request.getParameter("delFlag");
        Map<String, Object> requestMaps = new HashMap<>(20);
        requestMaps.put("loginName", loginName);
        requestMaps.put("userName", userName);
        requestMaps.put("phone", phone);
        requestMaps.put("status", status);
        requestMaps.put("delFlag", delFlag);
        Map<String, Object> dataMap = sysUserService.sysUserInfoList(page, limit, requestMaps);
        return JSONObject.toJSONString(dataMap);
    }

    /**
     * 删除用户信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/delSysUser")
    @ResponseBody
    public String delSysUser(HttpServletRequest request) {
        String userIds = request.getParameter("userIds");
        Map<String, Object> dataMap = sysUserService.delSysUser(userIds);
        return JSONObject.toJSONString(dataMap);
    }

    /**
     * 编辑用户信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/editSysUserInfo")
    @ResponseBody
    public String editSysUserInfo(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        String deptId = request.getParameter("deptId");
        String loginName = request.getParameter("loginName");
        String userName = request.getParameter("userName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String userType = request.getParameter("userType");
        String avatar = request.getParameter("avatar");
        String password = request.getParameter("password");
        String salt = request.getParameter("salt");
        String sex = request.getParameter("sex");
        String status = request.getParameter("status");
        String delFlag = request.getParameter("delFlag");
        String remark = request.getParameter("remark");
        Map<String, Object> requestMaps = new HashMap<>(20);
        requestMaps.put("userId", userId);
        requestMaps.put("deptId", "".equals(deptId) ? null : deptId);
        requestMaps.put("loginName", loginName);
        requestMaps.put("userName", userName);
        requestMaps.put("phone", phone);
        requestMaps.put("email", email);
        requestMaps.put("userType", userType);
        requestMaps.put("avatar", avatar);
        requestMaps.put("password", password);
        requestMaps.put("salt", salt);
        requestMaps.put("sex", sex);
        requestMaps.put("status", status);
        requestMaps.put("delFlag", delFlag);
        requestMaps.put("remark", remark);
        Map<String, Object> dataMap = sysUserService.editSysUserInfo(requestMaps);
        return JSONObject.toJSONString(dataMap);
    }

    /**
     * 添加用户信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/addSysUserInfo")
    @ResponseBody
    public String addSysUserInfo(HttpServletRequest request) {
        String deptId = request.getParameter("deptId");
        String loginName = request.getParameter("loginName");
        String userName = request.getParameter("userName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String userType = request.getParameter("userType");
        String avatar = request.getParameter("avatar");
        String password = request.getParameter("password");
        String salt = request.getParameter("salt");
        String sex = request.getParameter("sex");
        String status = request.getParameter("status");
        String delFlag = request.getParameter("delFlag");
        String remark = request.getParameter("remark");
        Map<String, Object> requestMaps = new HashMap<>(20);
        requestMaps.put("deptId", "".equals(deptId) ? null : deptId);
        requestMaps.put("loginName", loginName);
        requestMaps.put("userName", userName);
        requestMaps.put("phone", phone);
        requestMaps.put("email", email);
        requestMaps.put("userType", userType);
        requestMaps.put("avatar", avatar);
        requestMaps.put("password", password);
        requestMaps.put("salt", salt);
        requestMaps.put("sex", sex);
        requestMaps.put("status", status);
        requestMaps.put("delFlag", delFlag);
        requestMaps.put("remark", remark);
        Map<String, Object> dataMap = sysUserService.addSysUserInfo(requestMaps);
        return JSONObject.toJSONString(dataMap);
    }

    /**
     * 上传用户头像
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/uploadAvatarIcon")
    @ResponseBody
    public String uploadAvatarIcon(HttpServletRequest request) {
        Map<String, Object> dataMap = sysUserService.uploadAvatarIcon(request);
        return JSONObject.toJSONString(dataMap);
    }

    /**
     * 新增、修改用户时（点击取消操作，发送消息）
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/canceluploadAvatarIcon")
    @ResponseBody
    public String canceluploadAvatarIcon(HttpServletRequest request) {
        String filePtah = request.getParameter("filePtah");
        String path = request.getParameter("path");
        if("".equals(path)){
            return null;
        }
        Map<String, Object> dataMap = sysUserService.canceluploadAvatarIcon(path);
        return JSONObject.toJSONString(dataMap);
    }
}
