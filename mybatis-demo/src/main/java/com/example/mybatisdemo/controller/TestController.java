package com.example.mybatisdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author komiles@163.com
 * @date 2020-04-29 14:43
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "OK";
    }
}
