package com.coffee.kafeisummary.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * @author kafei
 * @Title: DefaultController
 * @Package  com.coffee.kafeisummary.config
 * @Description: 配置启动访问页面（login.html)
 * @date 2020/6/22 15:29
 */
@Configuration
public class DefaultController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}
