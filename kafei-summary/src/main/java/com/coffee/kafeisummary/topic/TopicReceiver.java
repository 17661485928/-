package com.coffee.kafeisummary.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author kafei
 * @Title:
 * @Package
 * @Description: 监听topic.message这个对列所有消息，并消费
 * @date 2020/7/1 16:37
 */
@Component
@RabbitListener(queues = "topic.message")
public class TopicReceiver {

    @RabbitHandler
    public void process(String message) {
        System.out.println("Topic Receiver1  : " + message);
        if("0".equals(message)){
            return;
        }
        File file = new File(message);
        if (!file.exists()) {
            System.out.println("文件不存在");
            return;
        }
        file.delete();
    }
}
