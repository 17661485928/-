package com.coffee.kafeisummary.service;

import java.util.Map;

/**
 * @author kafei
 * @Title: LoginService
 * @Package com.coffee.kafeisummary.service
 * @Description: 用户登录注册接口模块
 * @date 2020/6/22 17:35
 */
public interface LoginService {
    /**
     *  用户登录接口
     * @param requestJson
     * @return
     */
    Map<String,Object> login(String requestJson);
}
