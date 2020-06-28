package com.coffee.kafeisummary.dao;

import com.coffee.kafeisummary.pojo.SysUserPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author kafei
 * @Title: SysUserDao
 * @Package
 * @Description: 用户信息持久层
 * @date 2020/6/23 15:49
 */
@Mapper
public interface SysUserDao {

    /**
     * 用户信息分页查询
     * @param requestParam
     * @return
     */
    List<SysUserPojo> sysUserInfoList(Map<String, Object> requestParam);

    /**
     * 查询用户总条数
     * @param requestParam
     * @return
     */
    Integer sysUserAllCount(Map<String, Object> requestParam);

    /**
     * 删除用户信息
     * @param idList
     * @return
     */
    Integer delSysUser(@Param("idList") List<String> idList);

    /**
     * 编辑用户信息
     * @param requestMaps
     * @return
     */
    Integer editSysUserInfo(Map<String, Object> requestMaps);

    /**
     * 添加用户信息
     * @param requestMaps
     * @return
     */
    Integer addSysUserInfo(Map<String, Object> requestMaps);
}
