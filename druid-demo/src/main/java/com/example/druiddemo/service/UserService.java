package com.example.druiddemo.service;

import com.example.druiddemo.common.PageDTO;
import com.example.druiddemo.dao.User;

/**
 * @author komiles@163.com
 * @date 2020-04-30 18:49
 */
public interface UserService {

    User getOne(Integer id);

    PageDTO<User> getList(Integer pageNum, Integer pageSize);
}
