package com.coffee.kafeisummary.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

/**
 * @author kafei
 * @Title: CloseListener
 * @Package
 * @Description: 程序停止事件监听器
 * @date 2020/7/9 16:52
 */
public class CloseListener implements ApplicationListener<ContextClosedEvent> {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        ApplicationContext applicationContext = contextClosedEvent.getApplicationContext();
        TomcatConfig tomcatConfig = (TomcatConfig) applicationContext.getBean("tomcatConfig");
        String path = tomcatConfig.getPath();
        String httpAddr = tomcatConfig.getHttpAddr();
        TomcatServer.stop(path,httpAddr);
        logger.info(">>>>>>>>>>>>>>>>>>程序服务停止！<<<<<<<<<<<<<<<<<<");
    }
}
