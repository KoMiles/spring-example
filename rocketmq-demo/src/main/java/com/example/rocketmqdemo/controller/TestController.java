package com.example.rocketmqdemo.controller;

import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.springframework.messaging.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author komiles@163.com
 * @date 2020-06-09 19:12
 */
@RequestMapping("/message")
@RestController
@Slf4j
public class TestController {


    @Resource
    private RocketMQTemplate template;

    @Value(value = "${rocketmq.producer.topic}")
    private String topic;

    @GetMapping("/send")
    public String send(@RequestParam(value = "string") String string){
//        string = "我是要发送的字符串";
        log.info("设置字符串:{}", string);
        Message msg = MessageBuilder.withPayload(string).build();
        SendResult sendResult = template.syncSend(topic,msg);
        log.info("syncSend to queue, topic {}, sendResult={}",topic,sendResult.toString());
        return string;
    }

}
