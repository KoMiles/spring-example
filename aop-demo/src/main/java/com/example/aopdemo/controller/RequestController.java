package com.example.aopdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    // http://localhost:8091/getTest/123
    @GetMapping("/getTest/{id}")
    public String getTest(@PathVariable("id") Integer userId)
    {
        return "userId:"+userId+" this is get test data";
    }

    // http://localhost:8091/getTest2?id=123
    @GetMapping("/getTest2")
    public String getTest2(@RequestParam(value = "id",defaultValue = "666",required = false) Integer userId)
    {
        return "userId:"+userId+" this is get test data";
    }
}
