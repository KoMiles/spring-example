package com.example.mybatisdemo.controller;

import com.example.mybatisdemo.domain.User;
import com.example.mybatisdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author komiles@163.com
 * @date 2020-04-29 14:43
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    UserService userService;

    @GetMapping("/test")
    public String test(){
        return "OK";
    }

    @GetMapping("random")
    public void random(){
        int size = 100;
        for(int i=0;i<size;i++){
            Random r = new Random();
            Integer randNum = Math.abs(r.nextInt()%100);
//            log.info("记录id：{},随机数：{}",i,randNum);

            User user = new User();
            user.setPassword("000"+i+randNum);
            user.setUsername("wang"+i+randNum);
            userService.save(user);
        }
    }
}
