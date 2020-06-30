package com.coffee.kafeisummary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author kafei
 * @Title: PageJumpController
 * @Package com.coffee.kafeisummary.controller
 * @Description: 页面跳转入口模块
 * @date 2020/6/22 15:26
 */
@Controller
@RequestMapping(value = "/PageJumpController")
public class PageJumpController {

    /**
     * 跳转登录界面
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }
    /**
     * 登录成功之后跳转到首页
     * @return
     */
    @RequestMapping(value = "/index")
    public ModelAndView index(HttpServletRequest request) throws UnsupportedEncodingException {
        ModelAndView mvn = new ModelAndView();
        String loginname = request.getParameter("loginname");
        String avatar = request.getParameter("avatar");
        mvn.addObject("loginname",loginname);
        mvn.addObject("avatar", URLEncoder.encode(avatar,"utf-8"));
        mvn.setViewName("index");
        return mvn;
    }
    /**
     * 首页中心展示默认页面
     * @return
     */
    @RequestMapping(value = "/defaultHome")
    public String defaultHome(){
        return "home/defaultHome";
    }
    /**
     * 用户信息页面
     * @return
     */
    @RequestMapping(value = "/sysUserInfo")
    public String sysUserInfo(){
        return "home/SysUserInfo";
    }
    /**
     * 每日计划页面
     * @return
     */
    @RequestMapping(value = "/DailyPlan")
    public String DailyPlan(){
        return "plan/DailyPlan";
    }
    /**
     * 每月计划页面
     * @return
     */
    @RequestMapping(value = "/MonthlyPlan")
    public String MonthlyPlan(){
        return "plan/MonthlyPlan";
    }
    /**
     * 计划ALL页面
     * @return
     */
    @RequestMapping(value = "/PlanAll")
    public String PlanAll(){
        return "plan/PlanAll";
    }
}
