package com.example.apollodemo.service;

import com.example.apollodemo.dao.User;

/**
 * @author komiles@163.com
 * @date 2020-05-06 18:41
 */
public interface UserService {

    User getOne(Integer id);
}
