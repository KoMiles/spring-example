package com.example.aopdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/hello")
public class HelloController {

//    @GetMapping("/hello/say")
    @RequestMapping(path = "/hello/say",method = RequestMethod.GET)
    public String Say()
    {
        return "this is say data";
    }


    @RequestMapping(path = "/hello/hi",method = RequestMethod.GET)
    public String hi()
    {
        return "this is hi data";
    }
}
