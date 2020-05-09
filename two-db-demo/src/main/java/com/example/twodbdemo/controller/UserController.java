package com.example.twodbdemo.controller;

import com.example.twodbdemo.dao.komoDao.User;
import com.example.twodbdemo.dao.mfwDao.UserBase;
import com.example.twodbdemo.service.komo.UserService;
import com.example.twodbdemo.service.mfw.UserBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author komiles@163.com
 * @date 2020-05-09 14:39
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserBaseService userBaseService;

    @GetMapping("/komo/id")
    public User getOne(@RequestParam(value = "id") Integer id){
        return userService.getOne(id);
    }

    @GetMapping("/mfw/id")
    public UserBase getBaseOne(@RequestParam(value = "id") Integer id){
        return userBaseService.getOne(id);
    }

}
