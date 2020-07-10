package com.coffee.kafeisummary.service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author kafei
 * @Title: UploadService
 * @Package
 * @Description:
 * @date 2020/7/10 15:24
 */
public interface UploadService {

    /**
     * 上传
     * @param request
     * @return
     */
    Map<String, Object> upload(HttpServletRequest request);

    /**
     * 查询文件信息
     * @param userId
     * @return
     */
    Map<String, Object> selectSysFileInfo(String userId);
}
