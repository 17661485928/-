package com.kafei.usercoffee.model;

/**
 * @author kafei
 * @Title: PermissionModel
 * @Package com.kafei.usermodules.model
 * @Description: 权限实体类
 * @date 2020/5/28 11:40
 */
public class Permission {

    private Integer id;
    private String url;
    private String permName;
    private String permTag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName;
    }

    public String getPermTag() {
        return permTag;
    }

    public void setPermTag(String permTag) {
        this.permTag = permTag;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", permName='" + permName + '\'' +
                ", permTag='" + permTag + '\'' +
                '}';
    }
}
