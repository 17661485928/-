package com.coffee.kafeisummary.dao;

import com.coffee.kafeisummary.pojo.SysUserPojo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author kafei
 * @Title: LoginDao
 * @Package com.coffee.kafeisummary.dao
 * @Description: 用户登录注册持久层
 * @date 2020/6/22 17:41
 */
@Mapper
public interface LoginDao {

    /**
     * 用户登录
     * @param username
     * @return
     */
    SysUserPojo login(String username);
}
