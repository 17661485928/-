package com.kafei.usercoffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kafei
 * @Title:
 * @Package
 * @Description:
 * @date 2020/6/3 13:53
 */
@Controller
public class JumpController {

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
     * 跳转注册
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
     * @return
     */
    @RequestMapping(value = "/toHome")
    public Object toHome() {
        return "home";
    }
    /**
     * 跳转管理首页
     * @return
     */
    @RequestMapping(value = "/indexMent")
    public Object indexMent() {
        return "management/indexMent";
    }
    /**
     * 跳转管理首页
     * @return
     */
    @RequestMapping(value = "/listMent")
    public Object listMent() {
        return "management/list";
    }
    /**
     * 跳转用户信息
     * @return
     */
    @RequestMapping(value = "/userInfo")
    public Object userInfo() {
        return "management/userInfo";
    }
    /**
     * 跳转角色信息
     * @return
     */
    @RequestMapping(value = "/roleInfo")
    public Object roleInfo() {
        return "management/roleInfo";
    }
    /**
     * 跳转角色信息
     * @return
     */
    @RequestMapping(value = "/addRole")
    public Object addRole() {
        return "management/addRole";
    }
    /**
     * 客户端首页
     * @return
     */
    @RequestMapping(value = "/")
    public Object toIndex() {

        return "home/indexCoffee";
    }

    /**
     * 注销
     * @return
     */
    @RequestMapping(value = "/logout")
    public Object logout() {
        return "login";
    }
}
