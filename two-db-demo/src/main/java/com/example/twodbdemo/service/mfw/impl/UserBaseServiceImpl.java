package com.example.twodbdemo.service.mfw.impl;

import com.example.twodbdemo.dao.mfwDao.UserBase;
import com.example.twodbdemo.mapper.mfwMapper.UserBaseMapper;
import com.example.twodbdemo.service.mfw.UserBaseService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author komiles@163.com
 * @date 2020-05-09 14:32
 */
@Service
public class UserBaseServiceImpl implements UserBaseService {

    @Resource
    UserBaseMapper userBaseMapper;

    @Override
    public UserBase getOne(Integer id) {
        return userBaseMapper.selectByPrimaryKey(id.longValue());
    }
}
