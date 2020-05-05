package com.example.pagehelperdemo.service.impl;

import com.example.pagehelperdemo.common.PageDTO;
import com.example.pagehelperdemo.dao.User;
import com.example.pagehelperdemo.dao.UserExample;
import com.example.pagehelperdemo.mapper.UserMapper;
import com.example.pagehelperdemo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author komiles@163.com
 * @date 2020-04-30 18:50
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getOne(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageDTO<User> getList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        UserExample userExample = new UserExample();
        userExample.createCriteria();

        List<User> userList = userMapper.selectByExample(userExample);

        PageInfo pageInfo = new PageInfo(userList);

        PageDTO result = new PageDTO(
                pageInfo.getTotal(),
                pageInfo.getPageNum(),
                pageInfo.getPageSize(),
                pageInfo.getList());

        return result;
    }
}
