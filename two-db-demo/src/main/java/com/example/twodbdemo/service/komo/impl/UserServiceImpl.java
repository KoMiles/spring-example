package com.example.twodbdemo.service.komo.impl;

import com.example.twodbdemo.dao.komoDao.User;
import com.example.twodbdemo.mapper.komoMapper.UserMapper;
import com.example.twodbdemo.service.komo.UserService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author komiles@163.com
 * @date 2020-05-09 14:32
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
