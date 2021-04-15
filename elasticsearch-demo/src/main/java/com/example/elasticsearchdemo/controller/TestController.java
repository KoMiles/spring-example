package com.example.elasticsearchdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author komiles@163.com
 * @date 2021-04-15 18:05
 */
@RestController
@RequestMapping("/es")
public class TestController {

    @GetMapping("/say")
    public String say(){
        return "Hello ES";
    }
}
