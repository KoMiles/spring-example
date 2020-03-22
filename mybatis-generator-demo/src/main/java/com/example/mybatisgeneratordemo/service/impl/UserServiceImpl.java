package com.example.mybatisgeneratordemo.service.impl;

import com.example.mybatisgeneratordemo.domain.User;
import com.example.mybatisgeneratordemo.mapper.UserMapper;
import com.example.mybatisgeneratordemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author komiles@163.com
 * @date 2020-03-22 22:58
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
