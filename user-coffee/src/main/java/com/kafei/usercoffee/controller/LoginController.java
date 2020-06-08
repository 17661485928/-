package com.kafei.usercoffee.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kafei.usercoffee.model.Role;
import com.kafei.usercoffee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户登录模块
 */
@Controller
@RequestMapping(value = "/LoginController")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userRegister")
    public void userRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String,Object> params = new HashMap<>();
        params.put("username",request.getParameter("username"));
        params.put("password",request.getParameter("password"));
        params.put("real_name",request.getParameter("real_name"));
        params.put("real_lage",request.getParameter("real_lage"));
        params.put("birthday",request.getParameter("birthday"));
        params.put("myemail",request.getParameter("myemail"));
        params.put("telphone",request.getParameter("telphone"));
        params.put("lovecolor",request.getParameter("lovecolor"));
        userService.userRegister(params);
        response.sendRedirect("/login");
    }

    @RequestMapping(value = "/roleInfoList")
    @ResponseBody
    public String roleInfoList(HttpServletRequest request) {
        String page = request.getParameter("page");//当前页码
        String limit = request.getParameter("limit");//每页中数据的条数
        Map<String,Object> dataMap = userService.roleInfoList(page,limit);
        return JSONObject.toJSONString(dataMap);
    }
    @RequestMapping(value = "/delRole")
    @ResponseBody
    public String delRole(HttpServletRequest request) {
        String id = request.getParameter("id");
        Map<String,Object> dataMap = userService.delRole(id);
        return JSONObject.toJSONString(dataMap);
    }
    @RequestMapping(value = "/addRoleInfo")
    @ResponseBody
    public String addRoleInfo(HttpServletRequest request) {
        String rolename = request.getParameter("rolename");
        String des = request.getParameter("des");
        Map<String,Object> dataMap = userService.addRoleInfo(rolename,des);
        return JSONObject.toJSONString(dataMap);
    }
    @RequestMapping(value = "/editRoleInfo")
    @ResponseBody
    public String editRoleInfo(HttpServletRequest request) {
        String id = request.getParameter("id");
        String rolename = request.getParameter("rolename");
        String des = request.getParameter("des");
        Map<String,Object> dataMap = userService.editRoleInfo(id,rolename,des);
        return JSONObject.toJSONString(dataMap);
    }
    @RequestMapping(value = "/permInfoList")
    @ResponseBody
    public String permInfoList(HttpServletRequest request) {
        String page = request.getParameter("page");//当前页码
        String limit = request.getParameter("limit");//每页中数据的条数
        Map<String,Object> dataMap = userService.permInfoList(page,limit);
        return JSONObject.toJSONString(dataMap);
    }
    @RequestMapping(value = "/userInfoList")
    @ResponseBody
    public String userInfoList(HttpServletRequest request) {
        String page = request.getParameter("page");//当前页码
        String limit = request.getParameter("limit");//每页中数据的条数
        Map<String,Object> dataMap = userService.userInfoList(page,limit);
        return JSONObject.toJSONString(dataMap);
    }
    @RequestMapping(value = "/addUserInfo")
    @ResponseBody
    public String addUserInfo(HttpServletRequest request) {
        Map<String,Object> params = new HashMap<>();
        params.put("username",request.getParameter("username"));
        params.put("password",request.getParameter("password"));
        params.put("real_name",request.getParameter("real_name"));
        params.put("real_lage",request.getParameter("real_lage"));
        params.put("birthday",request.getParameter("birthday"));
        params.put("myemail",request.getParameter("myemail"));
        params.put("telphone",request.getParameter("telphone"));
        params.put("lovecolor",request.getParameter("lovecolor"));
        Map<String,Object> dataMap = userService.addUserInfo(params);
        return JSONObject.toJSONString(dataMap);
    }
    @RequestMapping(value = "/addPermInfo")
    @ResponseBody
    public String addPermInfo(HttpServletRequest request) {
        String url = request.getParameter("url");
        String permName = request.getParameter("permName");
        String permTag = request.getParameter("permTag");
        Map<String,Object> dataMap = userService.addPermInfo(url,permName,permTag);
        return JSONObject.toJSONString(dataMap);
    }
    @RequestMapping(value = "/delPerm")
    @ResponseBody
    public String delPerm(HttpServletRequest request) {
        String id = request.getParameter("id");
        Map<String,Object> dataMap = userService.delPerm(id);
        return JSONObject.toJSONString(dataMap);
    }

    @RequestMapping(value = "/editPermInfo")
    @ResponseBody
    public String editPermInfo(HttpServletRequest request) {
        String id = request.getParameter("id");
        String url = request.getParameter("url");
        String permName = request.getParameter("permName");
        String permTag = request.getParameter("permTag");
        Map<String,Object> dataMap = userService.editPermInfo(id,url,permName,permTag);
        return JSONObject.toJSONString(dataMap);
    }
    @RequestMapping(value = "/roleAuthorization")
    @ResponseBody
    public String roleAuthorization(HttpServletRequest request) {
        String id = request.getParameter("id");
        String roleId = request.getParameter("roleId");
        Map<String,Object> dataMap = userService.roleAuthorization(id,roleId);
        return JSONObject.toJSONString(dataMap);
    }
    @RequestMapping(value = "/roleToUser")
    @ResponseBody
    public String roleToUser(HttpServletRequest request) {
        String id = request.getParameter("id");
        String ids = request.getParameter("ids");
        Map<String,Object> dataMap = userService.roleToUser(id,ids);
        return JSONObject.toJSONString(dataMap);
    }
    @RequestMapping(value = "/userAllroleInfoList")
    @ResponseBody
    public String userAllroleInfoList(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        String page = request.getParameter("page");//当前页码
        String limit = request.getParameter("limit");//每页中数据的条数
        Map<String,Object> dataMap = userService.userAllroleInfoList(userId,page,limit);
        return JSONObject.toJSONString(dataMap);
    }
    @RequestMapping(value = "/roleAllPermInfoList")
    @ResponseBody
    public String roleAllPermInfoList(HttpServletRequest request) {
        String roleId = request.getParameter("roleId");
        String page = request.getParameter("page");//当前页码
        String limit = request.getParameter("limit");//每页中数据的条数
        Map<String,Object> dataMap = userService.roleAllPermInfoList(roleId,page,limit);
        return JSONObject.toJSONString(dataMap);
    }
    @RequestMapping(value = "/delUser")
    @ResponseBody
    public String delUser(HttpServletRequest request) {
        String userIds = request.getParameter("userIds");
        Map<String,Object> dataMap = userService.delUser(userIds);
        return JSONObject.toJSONString(dataMap);
    }
}