package com.coffee.kafeisummary.controller;

import com.alibaba.fastjson.JSONObject;
import com.coffee.kafeisummary.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author kafei
 * @Title:
 * @Package
 * @Description: 文件上传
 * @date 2020/7/10 15:23
 */
@Controller
@RequestMapping(value = "/UploadController")
public class UploadController {


    @Autowired
    private UploadService uploadService;
    /**
     * 上传
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/upload")
    @ResponseBody
    public String upload(HttpServletRequest request) {
        Map<String, Object> dataMap = uploadService.upload(request);
        return JSONObject.toJSONString(dataMap);
    }
    /**
     * 查询文件信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/selectSysFileInfo")
    @ResponseBody
    public String selectSysFileInfo(HttpServletRequest request) {
        Map<String, Object> dataMap = uploadService.selectSysFileInfo(request.getParameter("userId"));
        return JSONObject.toJSONString(dataMap);
    }

}
