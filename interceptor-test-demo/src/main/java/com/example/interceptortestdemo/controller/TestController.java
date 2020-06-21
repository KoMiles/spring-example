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


    @GetMapping("/index")
    public void index(){
        int a = 123;
        String b = String.valueOf(a);
        log.info("b为：{},b的类型为：{}",b,b.getClass());
        Integer c = 456;
        String d = c.toString();
        log.info("d为：{},d的类型为：{}",d,d.getClass());
    }
}
