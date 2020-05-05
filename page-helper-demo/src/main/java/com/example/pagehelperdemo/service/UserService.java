package com.example.pagehelperdemo.service;

import com.example.pagehelperdemo.common.PageDTO;
import com.example.pagehelperdemo.dao.User;
import java.util.List;

/**
 * @author komiles@163.com
 * @date 2020-04-30 18:49
 */
public interface UserService {

    User getOne(Integer id);

    PageDTO<User> getList(Integer pageNum, Integer pageSize);
}
