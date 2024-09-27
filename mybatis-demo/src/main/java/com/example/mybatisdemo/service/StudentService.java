package com.example.mybatisdemo.service;

import com.example.mybatisdemo.domain.UserStudent;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {

    Integer save(UserStudent student);


    List<UserStudent> getList();



}
