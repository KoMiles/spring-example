package com.example.aopdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/hello/say")
//    @RequestMapping(value = "123",path = "/hello/say",method = RequestMethod.GET)
    public String Say()
    {
        String res = "this is return data";
        return res;
    }
}
