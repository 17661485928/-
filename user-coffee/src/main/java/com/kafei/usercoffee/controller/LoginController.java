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
}