package com.example.mybatisgeneratordemo.controller;

import com.example.mybatisgeneratordemo.domain.User;
import com.example.mybatisgeneratordemo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author komiles@163.com
 * @date 2020-03-22 23:08
 */
@RequestMapping("/test")
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/userInfo")
    public User getUserInfo(@RequestParam("user_id") Integer id)
    {
        System.out.println(id);
        return userService.getUser(id);
    }
}
