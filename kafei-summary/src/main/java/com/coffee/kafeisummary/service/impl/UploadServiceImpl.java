package com.coffee.kafeisummary.service.impl;

import com.coffee.kafeisummary.dao.UploadDao;
import com.coffee.kafeisummary.pojo.SysFilePojo;
import com.coffee.kafeisummary.service.UploadService;
import com.coffee.kafeisummary.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author kafei
 * @Title: UploadServiceImpl
 * @Package
 * @Description:
 * @date 2020/7/10 15:24
 */
@Service
public class UploadServiceImpl implements UploadService {

    @Value("${image.tomcat.path}")
    private String path;
    @Value("${image.tomcat.httpAddr}")
    private String httpAddr;
    @Autowired
    private UploadDao uploadDao;

    @Override
    public Map<String, Object> upload(HttpServletRequest request) {
        Map<String, Object> responseMap = new HashMap<>();
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                //取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    //取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    assert myFileName != null;
                    if (!"".equals(myFileName.trim())) {
                        System.out.println(myFileName);
                        String suffix = myFileName.substring(myFileName.lastIndexOf(".") + 1);
                        //重命名上传后的文件名  按照年月日时分秒进行命名
                        String fileName = DateUtil.getImgPath("yyyyMMddHHmmssSSS") +
                                Integer.toHexString(new Random().nextInt()) + "." + suffix;
                        //定义上传路径
                        try {
                            //获取文件保存路径
                            String addr = path+"\\image";
                            File fileDir = new File(addr);
                            //如果不存在 则创建
                            if (!fileDir.exists()) {
                                fileDir.mkdirs();
                            }
                            String filePath = addr +"\\"+ fileName;
                            //存文件
                            File localFile = new File(filePath);
                            file.transferTo(localFile);
                            String httpPath = httpAddr+"image/"+fileName;
                            System.out.println(httpPath);
                            responseMap.put("code", 200);
                            responseMap.put("msg", "上传成功！");
                            responseMap.put("filePath", httpPath);
                            responseMap.put("path", filePath);
                            Map<String,Object> resMaps = new HashMap<>();
                            resMaps.put("file_old_name",myFileName);
                            resMaps.put("file_new_name",fileName);
                            resMaps.put("file_size",localFile.length());
                            resMaps.put("file_suffix",suffix);
                            resMaps.put("file_path",httpPath);
                            String userId = request.getParameter("userId");
                            resMaps.put("userId",userId);
                            uploadDao.insertFileInfo(resMaps);
                        } catch (IllegalStateException | IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                            responseMap.put("code", 201);
                            responseMap.put("msg", "上传失败！"+e.getMessage());
                            return responseMap;
                        }
                    }
                } else {
                    responseMap.put("code", 201);
                    responseMap.put("msg", "上传失败！");
                }
            }
        } else {
            responseMap.put("code", 201);
            responseMap.put("msg", "上传失败！");
        }
        return responseMap;
    }

    /**
     * 查询文件信息
     * @param userId
     * @return
     */
    @Override
    public Map<String, Object> selectSysFileInfo(String userId) {
        Map<String, Object> responseMap = new HashMap<>();
        Map<String, Object> requestMaps = new HashMap<>();
        requestMaps.put("userId", userId);
        requestMaps.put("avatar", "");
        List<SysFilePojo> sysFilePojoList = uploadDao.selectSysFileInfo(requestMaps);
        responseMap.put("code", 200);
        responseMap.put("msg", "成功！");
        responseMap.put("data", sysFilePojoList);
        return responseMap;
    }
}
