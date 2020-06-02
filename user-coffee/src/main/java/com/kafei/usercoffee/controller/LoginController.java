package com.kafei.usercoffee.controller;

import com.kafei.usercoffee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户登录模块
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping(value = "/login")
    public Object toLoginHtml(){
        return "login";
    }
    @RequestMapping(value = "/we/toTest")
    public Object toTest(){
        return "test";
    }
    /**
     * 跳转首页
     * @return
     */
    @RequestMapping(value = "/toHome")
    public Object toHome(){

        return "home";
    }
    @RequestMapping(value = "/logout")
    public Object logout(){
        return "login";
    }
    @RequestMapping(value = "/queryUserInformationByUserName")
    @ResponseBody
    public Object queryUserInformationByUserName (){
        return userService.queryUserInformationByUserName("");
    }
}