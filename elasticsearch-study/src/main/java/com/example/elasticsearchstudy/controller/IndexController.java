package com.example.elasticsearchstudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author komiles@163.com
 * @date 2021-04-18 22:59
 */
@RestController
@RequestMapping("test")
public class IndexController {

    @GetMapping("/hello")
    public String sayHello()
    {
        return "Hello test~!";
    }

}
