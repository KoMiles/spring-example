package com.example.apollodemo.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import com.alibaba.fastjson.JSON;
import com.example.apollodemo.dao.User;
import com.example.apollodemo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author komiles@163.com
 * @date 2020-05-06 18:44
 */
class UserServiceImplTest {

    @Autowired
    UserServiceImpl userService;

    @Test
    public void getOne() {

        User user = userService.getOne(1);
        System.out.println(JSON.toJSONString(user,true));
    }
}