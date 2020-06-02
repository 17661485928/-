package com.kafei.usermodules.model;

/**
 * @author kafei
 * @Title:
 * @Package
 * @Description:
 * @date 2020/6/1 12:25
 */
public class Role {

    private Integer id;
    private String rolename;
    private String describe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
