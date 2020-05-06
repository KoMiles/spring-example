package com.example.apollodemo.controller;

import com.alibaba.fastjson.JSON;
import com.example.apollodemo.dao.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author komiles@163.com
 * @date 2020-05-06 17:15
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @GetMapping("/json")
    public void json()
    {
        User user = new User();
        user.setAge(20).setId(1).setName("张三").setPassword("123456");
        System.out.print(JSON.toJSONString(user,true));
//        System.out.print(user);
    }
}
