package com.example.apollodemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author komiles@163.com
 * @date 2020-05-06 14:13
 */
@RestController
@RequestMapping("/test")
public class HelloController {

//    @Value("${name}")
//    private String name;
//
//    @Value("${server.port}")
//    private Integer portNum;
//
//    @Value("${redis-ip}")
//    private String redisIp;

    @GetMapping("/hello")
    public String hello()
    {
        return "hello";
    }

//    @GetMapping("/port")
//    public Integer port()
//    {
//        return portNum;
//    }
//
//    @GetMapping("/ip")
//    public String ip()
//    {
//        System.out.println(redisIp);
//        return redisIp;
//    }

}
