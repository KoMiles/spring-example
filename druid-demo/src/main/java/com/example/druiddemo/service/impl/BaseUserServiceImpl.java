package com.example.druiddemo.service.impl;

import com.example.druiddemo.dao.mfw.BaseUser;
import com.example.druiddemo.mapper.mfw.BaseUserMapper;
import com.example.druiddemo.service.BaseUserService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author komiles@163.com
 * @date 2020-05-12 19:08
 */
@Service
public class BaseUserServiceImpl implements BaseUserService {
    @Resource
    BaseUserMapper baseUserMapper;


    @Override
    public BaseUser getOne(Integer id) {
        return baseUserMapper.selectByPrimaryKey(id.longValue());
    }
}
