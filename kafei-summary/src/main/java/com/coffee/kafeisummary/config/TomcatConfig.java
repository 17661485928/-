package com.coffee.kafeisummary.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;

/**
 * @author kafei
 * @Title:
 * @Package
 * @Description:
 * @date 2020/7/9 17:28
 */
@SpringBootConfiguration
public class TomcatConfig {

    @Value("${image.tomcat.path}")
    private String path;
    @Value("${image.tomcat.httpAddr}")
    private String httpAddr;

    public String getPath() {
        return path;
    }

    public String getHttpAddr() {
        return httpAddr;
    }
}
