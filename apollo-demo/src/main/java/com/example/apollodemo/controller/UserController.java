package com.example.apollodemo.controller;

import com.example.apollodemo.dao.User;
import com.example.apollodemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author komiles@163.com
 * @date 2020-05-06 17:15
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/one")
    public User one(@RequestParam("id") Integer id)
    {
        return userService.getOne(id);
    }
}
