package com.example.mybatisdemo.controller;

import com.example.mybatisdemo.domain.UserStudent;
import com.example.mybatisdemo.service.StudentService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/add")
    public Boolean add()
    {
        UserStudent student = new UserStudent();
        student.setName("张三");
        student.setAge(10);
        student.setAddress("张三的地址");
        student.setIntro("我是张三的介绍");

//        Date now = new Date();
//        String dateFormat = "yyyy-MM-dd HH:mm:ss";

//        String createTime = DateFormatUtils.format(now,dateFormat);
        student.setCtime(new Date());
        student.setUtime(new Date());

        Integer save = studentService.save(student);
        return save !=0;
    }

}
