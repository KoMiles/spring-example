package com.example.pagehelperdemo.controller;

import com.example.pagehelperdemo.common.PageDTO;
import com.example.pagehelperdemo.dao.User;
import com.example.pagehelperdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author komiles@163.com
 * @date 2020-04-30 18:47
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/one")
    public User getOne(@RequestParam("id") Integer id){
        return userService.getOne(id);
    }

    @GetMapping("/list")
    public PageDTO<User> getList(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit){
        return userService.getList(page,limit);
    }

}
