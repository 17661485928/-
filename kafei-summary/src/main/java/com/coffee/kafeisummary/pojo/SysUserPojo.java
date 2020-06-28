package com.coffee.kafeisummary.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author kafei
 * @Title: SysUserPojo
 * @Package
 * @Description: 用户对象实体
 * @date 2020/6/22 17:50
 */
@Data
public class SysUserPojo implements Serializable {

    private Long user_id;
    private Long dept_id;
    private String login_name;
    private String user_name;
    private String user_type;
    private String email;
    private String phonenumber;
    private String sex;
    private String avatar;
    private String password;
    private String salt;
    private String status;
    private String del_flag;
    private String login_ip;
    private Date login_date;
    private String create_by;
    private Date create_time;
    private String update_by;
    private Date update_time;
    private String remark;


}
