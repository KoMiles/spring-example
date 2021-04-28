package com.example.elasticsearchdemo.controller;

import com.example.elasticsearchdemo.model.UserTestModel;
import com.example.elasticsearchdemo.model.UserTestRepository;
import com.example.elasticsearchdemo.service.UserTestUpdateImpl;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author komiles@163.com
 * @date 2021-04-16 15:45
 */
@RestController
@RequestMapping("/userTest")
@Slf4j
public class UserTestController {
    @Autowired
    private UserTestRepository userRepository;

    @Autowired
    private UserTestUpdateImpl userUpdate;


    @PostMapping("/add")
    public String add(@RequestBody UserTestModel UserTestModel) {
        log.info("userTestModel:{}",UserTestModel.toString());
        userRepository.save(UserTestModel);
        return "OK";
    }


    @GetMapping("/get/{id}")
    public UserTestModel getById(@PathVariable String id)
    {
        Optional<UserTestModel> UserTestModel = userRepository.findById(id);
        UserTestModel UserTestModelOne = UserTestModel.get();
        return UserTestModelOne;
    }

    @PostMapping("/update")
    public UserTestModel update(@RequestBody UserTestModel userTestUpdate)
    {
        userUpdate.updateContent(userTestUpdate,userTestUpdate.getContent());
        Optional<UserTestModel> UserTestModelOptional = userRepository.findById(userTestUpdate.getId().toString());
        UserTestModel UserTestModelOne = UserTestModelOptional.get();
        return UserTestModelOne;
    }


    @PostMapping("/delete")
    public String deleteById(@RequestParam(value = "id") String id)
    {
        userRepository.deleteById(id);
        return "OK";
    }

}
