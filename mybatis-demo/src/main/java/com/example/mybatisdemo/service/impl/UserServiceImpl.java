package com.example.mybatisdemo.service.impl;

import com.example.mybatisdemo.domain.User;
import com.example.mybatisdemo.mapper.UserMapper;
import com.example.mybatisdemo.service.UserService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author komiles@163.com
 * @date 2020-04-29 14:54
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getList() {
        return userMapper.selectAll();
    }

    @Override
    public Integer save(User user) {
        return userMapper.insert(user);
    }


}
