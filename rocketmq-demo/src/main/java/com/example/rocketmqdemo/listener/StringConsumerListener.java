package com.example.rocketmqdemo.listener;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author komiles@163.com
 * @date 2020-06-09 19:14
 */
@Component
@RocketMQMessageListener(topic="${rocketmq.producer.topic}",consumerGroup = "${rocketmq.producer.group}")
public class StringConsumerListener implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        System.out.printf("接收到消息 message content:%s \n",s);
    }
}
