package com.example.mybatisdemo.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import com.example.mybatisdemo.domain.User;
import com.example.mybatisdemo.service.UserService;
import com.oracle.tools.packager.Log;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

/**
 * @author komiles@163.com
 * @date 2020-04-29 15:47
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    public void save() {

//        Integer[] idList = new Integer[100];
//        Random r = new Random();
//        Integer randNum = Math.abs(r.nextInt()%100);
//
//        for (Integer id:idList
//        ) {
//            log.info("记录id：{},随机数：{}",id,randNum);
//        }
//
//        User user = new User();
//        user.setPassword("00000000");
//        user.setUsername("wangkongming");
//        userService.save(user);
    }
}