package com.example.mybatisdemo.service.impl;

import com.example.mybatisdemo.domain.UserStudent;
import com.example.mybatisdemo.mapper.UserStudentMapper;
import com.example.mybatisdemo.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private UserStudentMapper studentMapper;
    @Override
    public Integer save(UserStudent student) {
        return studentMapper.insert(student);
    }

    @Override
    public List<UserStudent> getList() {
        return studentMapper.selectAll();
    }
}
