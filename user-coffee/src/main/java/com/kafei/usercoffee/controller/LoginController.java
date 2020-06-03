package com.kafei.usercoffee.controller;

import com.kafei.usercoffee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户登录模块
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * 跳转登录页面
     *
     * @return
     */
    @RequestMapping(value = "/login")
    public Object toLoginHtml() {
        return "login";
    }

    /**
     * 跳转登录页面
     *
     * @return
     */
    @RequestMapping(value = "/register")
    public Object register() {
        return "register";
    }

    @RequestMapping(value = "/we/toTest")
    public Object toTest() {
        return "test";
    }

    /**
     * 跳转首页
     *
     * @return
     */
    @RequestMapping(value = "/toHome")
    public Object toHome() {
        return "home";
    }

    /**
     * 跳转首页
     *
     * @return
     */
    @RequestMapping(value = "/")
    public Object toIndex() {

        return "home/indexCoffee";
    }
    @RequestMapping(value = "/logout")
    public Object logout() {
        return "login";
    }

    @RequestMapping(value = "/userRegister")
    public Object userRegister(HttpServletRequest request){
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
        return "login";
    }
}