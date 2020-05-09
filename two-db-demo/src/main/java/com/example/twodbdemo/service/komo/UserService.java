package com.example.twodbdemo.service.komo;

import com.example.twodbdemo.dao.komoDao.User;

/**
 * @author komiles@163.com
 * @date 2020-05-09 14:34
 */
public interface UserService {
    User getOne(Integer id);
}
