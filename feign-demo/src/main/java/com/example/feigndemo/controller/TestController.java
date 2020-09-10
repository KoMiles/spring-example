package com.example.feigndemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author komiles@163.com
 * @date 2020-09-10 10:21
 */
@RequestMapping("/test")
@RestController
public class TestController {

    @GetMapping("/name")
    public String getName(@RequestParam(defaultValue = "name") String name)
    {
        return name;
    }
}
