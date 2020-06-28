package com.coffee.kafeisummary.controller;

import com.coffee.kafeisummary.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kafei
 * @Title: LoginController
 * @Package com.coffee.kafeisummary.controller
 * @Description: 用户登录注册模块
 * @date 2020/6/22 16:08
 */
@Controller
@RequestMapping(value = "/LoginController")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 用户登录接口
     * @param request
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Object login(HttpServletRequest request){
        String requestJson = request.getParameter("request");
        return loginService.login(requestJson);
    }
}
