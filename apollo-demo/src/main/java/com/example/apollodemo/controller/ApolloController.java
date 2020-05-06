package com.example.apollodemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author komiles@163.com
 * @date 2020-05-06 17:28
 */
@RestController
@RequestMapping("/apollo")
public class ApolloController {

    @Value("${name}")
    private String name;

    @GetMapping("/name")
    public String name()
    {
        return name;
    }
}
