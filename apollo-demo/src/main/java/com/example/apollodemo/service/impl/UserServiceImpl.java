package com.example.apollodemo.service.impl;

import com.example.apollodemo.dao.User;
import com.example.apollodemo.mapper.UserMapper;
import com.example.apollodemo.service.UserService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author komiles@163.com
 * @date 2020-05-06 18:40
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public User getOne(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
