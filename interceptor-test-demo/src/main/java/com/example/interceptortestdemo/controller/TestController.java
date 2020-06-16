package com.example.interceptortestdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author komiles@163.com
 * @date 2020-06-16 16:21
 */
@RestController
@Slf4j
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public String hello()
    {
        log.info("this is {}",TestController.class);
        return "Hello";
    }
}
