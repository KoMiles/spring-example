package com.example.mybatisdemo.service;

import com.example.mybatisdemo.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author komiles@163.com
 * @date 2020-04-29 14:59
 */
@Service
public interface UserService {

    List<User> getList();

    Integer  save(User user);
}
