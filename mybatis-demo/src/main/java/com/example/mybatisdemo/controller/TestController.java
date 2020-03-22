package com.example.mybatisdemo.controller;

import com.example.mybatisdemo.dto.UserDTO;
import com.example.mybatisdemo.pojo.User;
import com.example.mybatisdemo.service.impl.UserServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author komiles@163.com
 * @date 2020-03-22 21:56
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserServiceImpl userService;


    @GetMapping("/userInfo")
    public User getUserInfo(@RequestParam(value = "user_id", defaultValue = "0") Integer id){

        User userInfo = userService.userInfo(id);
        if(userInfo == null) {
            return null;
        }
        return userInfo;
    }
}
