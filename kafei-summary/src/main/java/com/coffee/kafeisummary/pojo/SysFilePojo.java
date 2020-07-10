package com.coffee.kafeisummary.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author kafei
 * @Title:
 * @Package
 * @Description:
 * @date 2020/7/10 15:44
 */
@Data
public class SysFilePojo implements Serializable {

    private Long id;
    private String file_old_name;
    private String file_new_name;
    private String file_size;
    private String file_suffix;
    private String file_path;
    private Date create_time;
    private Date update_time;
    private String status;
    private Long userId;
}
