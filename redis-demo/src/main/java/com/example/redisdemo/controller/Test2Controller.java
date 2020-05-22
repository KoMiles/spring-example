package com.example.redisdemo.controller;

import com.example.redisdemo.dao.Person;
import com.example.redisdemo.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author komiles@163.com
 * @date 2020-05-22 15:13
 */

@RestController
@RequestMapping("/test2")
@Slf4j
public class Test2Controller {

    static final String USER_LIST_HASH_KEY = "student_list_0522_02";

    @Autowired
    RedisUtil redisUtil;


    @GetMapping("/set")
    public String setStr(@Param("key") String key, @Param("value") String value){
        redisUtil.set(key,value);
        return key;
    }

    @GetMapping("/get")
    public String setStr(@Param("key") String key){
        return redisUtil.get(key).toString();
    }

    @GetMapping("/hashSet")
    public String setHash(){
        Person person = new Person();
        person.setId("1").setName("张三");
        redisUtil.hset(USER_LIST_HASH_KEY,person.getId(),person);
        return "OK";
    }

//    @GetMapping("/hashGet")
//    public Object getHash(){
//        Person person = new Person();
//        person.setId("1").setName("张三");
//        return redisUtil.hget(USER_LIST_HASH_KEY,"1");
//    }

    @GetMapping(path = "/hashGet/{id}")
    public Object getHash2(@PathVariable("id") String id){
        log.info("传入参数为：{}",id);
        return redisUtil.hget(USER_LIST_HASH_KEY,id);
    }


    @GetMapping(path = "/{name}/{age}")
    public String getNameAndAge(@PathVariable("name") String name, @PathVariable("age") Integer age){
        return "姓名为："+name+"年龄为："+age;
    }

    @RequestMapping(path = "/test/{name}/{age}",method = RequestMethod.GET)
    public String getNameAndAge2(@PathVariable("name") String name, @PathVariable("age") Integer age){
        return "姓名为2："+name+"年龄为2："+age;
    }
}
