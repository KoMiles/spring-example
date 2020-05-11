package com.example.druiddemo.controller;


import com.example.druiddemo.common.PageDTO;
import com.example.druiddemo.dao.User;
import com.example.druiddemo.service.UserService;
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
    public PageDTO<User> getList(@RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "limit",defaultValue = "10") Integer limit){
        return userService.getList(page,limit);
    }

}
