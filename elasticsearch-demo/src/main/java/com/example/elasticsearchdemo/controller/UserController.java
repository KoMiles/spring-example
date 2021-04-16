package com.example.elasticsearchdemo.controller;

import com.example.elasticsearchdemo.model.UserModel;
import com.example.elasticsearchdemo.model.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author komiles@163.com
 * @date 2021-04-16 15:45
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public String add(@RequestBody UserModel userModel) {
        log.info("userModel:{}",userModel.toString());
        userRepository.save(userModel);
        return "OK";
    }
}
