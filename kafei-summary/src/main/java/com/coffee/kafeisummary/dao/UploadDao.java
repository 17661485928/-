package com.coffee.kafeisummary.dao;

import com.coffee.kafeisummary.pojo.SysFilePojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author kafei
 * @Title:
 * @Package
 * @Description:
 * @date 2020/7/10 15:35
 */
@Mapper
public interface UploadDao {

    void insertFileInfo(Map<String, Object> resMaps);

    List<SysFilePojo> selectSysFileInfo(Map<String, Object> requestMaps);
}
