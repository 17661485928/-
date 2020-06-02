package com.kafei.usermodules.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kafei
 * @Title:
 * @Package
 * @Description: 错误页面跳转模块
 * @date 2020/5/30 12:17
 */
@Controller
public class ErrorController {

    @RequestMapping(value = "/error/400")
    public Object error400(){
        return "error/400";
    }
    @RequestMapping(value = "/error/401")
    public Object error401(){
        return "error/401";
    }
    @RequestMapping(value = "/error/403")
    public Object error403(){
        return "error/403";
    }
    @RequestMapping(value = "/error/404")
    public Object error404(){
        return "error/404";
    }
    @RequestMapping(value = "/error/415")
    public Object error415(){
        return "error/415";
    }
    @RequestMapping(value = "/error/500")
    public Object error500(){
        return "error/500";
    }
}
