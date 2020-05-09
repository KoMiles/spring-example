package com.example.twodbdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author komiles@163.com
 * @date 2020-05-09 14:45
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/index")
    public String test(){
        return "OK";
    }
}
