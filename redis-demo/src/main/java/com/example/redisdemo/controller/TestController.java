package com.example.redisdemo.controller;

import com.example.redisdemo.dao.Person;
import com.example.redisdemo.service.RedisBbHelper;
import com.example.redisdemo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author komiles@163.com
 * @date 2020-05-22 15:13
 */

@RestController
@RequestMapping("/redis")
public class TestController {

    @Autowired
    RedisBbHelper<String, Person> redisBbHelper;


    static final String USER_LIST_HASH_KEY = "student_list_0522";

    @GetMapping("/test1")
    public void putPerson1(){

        Person person = new Person();
        person.setId("1").setName("张三");
        redisBbHelper.hashPut(USER_LIST_HASH_KEY,person.getId(),person);
    }

    @GetMapping("/test2")
    public void putPerson2(){

        Person person = new Person();
        person.setId("2").setName("李四");
        redisBbHelper.hashPut(USER_LIST_HASH_KEY,person.getId(),person);
    }

    @GetMapping("/get")
    public Person getPerson(@Param("id") String id)
    {
        return redisBbHelper.hashGet(USER_LIST_HASH_KEY,id);
    }


    @GetMapping("/get2")
    public Object getPerson2(@Param("id") String id)
    {
        RedisUtil redisObj = new RedisUtil();
        Object result = redisObj.hget(USER_LIST_HASH_KEY,id);
        return result;
    }
}
