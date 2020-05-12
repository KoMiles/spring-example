package com.example.druiddemo.service;

import com.example.druiddemo.dao.mfw.BaseUser;

/**
 * @author komiles@163.com
 * @date 2020-05-12 19:08
 */
public interface BaseUserService {
    BaseUser getOne(Integer id);
}
