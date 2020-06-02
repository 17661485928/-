package com.kafei.usermodules;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 用户服务模块--项目启动类
 * @author kafei
 * @Title: UserModulesApplication
 * @Package com.kafei.usermodules
 * @Description: 此注解是用来排除项目启动时加载的类@EnableAutoConfiguration
 * (exclude = {DataSourceAutoConfiguration.class})
 * @date 2020/5/27 16:15
 */
@SpringBootApplication
@MapperScan("com.kafei.usermodules.dao")
public class UserModulesApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserModulesApplication.class, args);
    }

}
