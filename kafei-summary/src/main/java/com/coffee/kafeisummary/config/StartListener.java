package com.coffee.kafeisummary.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
/**
 * @author kafei
 * @Title: StartListener
 * @Package
 * @Description: ApplicationEnvironmentPreparedEvent：spring boot
 * 对应Enviroment已经准备完毕，但此时上下文context还没有创建
 * @date 2020/7/9 16:51
 */
public class StartListener implements ApplicationListener<ContextRefreshedEvent> {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        TomcatConfig tomcatConfig = (TomcatConfig) applicationContext.getBean("tomcatConfig");
        String tomcatRootPath = tomcatConfig.getPath();
        String httpAddr = tomcatConfig.getHttpAddr();
        TomcatServer.start(tomcatRootPath,httpAddr);
        logger.info(">>>>>>>>>>>>>>>>>>程序服务启动！<<<<<<<<<<<<<<<<<<");
    }
}
