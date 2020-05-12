package com.example.druiddemo.service.impl;


import com.example.druiddemo.common.PageDTO;
import com.example.druiddemo.dao.komo.User;
import com.example.druiddemo.dao.komo.UserExample;
import com.example.druiddemo.mapper.komo.UserMapper;
import com.example.druiddemo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import javax.annotation.Resource;
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
