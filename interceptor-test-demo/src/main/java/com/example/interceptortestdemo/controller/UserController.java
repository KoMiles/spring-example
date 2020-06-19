package com.example.interceptortestdemo.controller;

import com.example.interceptortestdemo.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author komiles@163.com
 * @date 2020-06-19 19:06
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {


    @GetMapping(path = "/id/{userId}")
    public UserDao getUserById(@PathVariable("userId") Integer userId){
        UserDao userDao = new UserDao();

        String password = String.valueOf((Math.random()*100));
        userDao.setUserId(userId).setPassword(password).setUserName("张三");
        return userDao;
    }
}
