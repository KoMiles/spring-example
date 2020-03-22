package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author komiles@163.com
 * @date 2020-03-22 19:57
 */
@Mapper
public interface UserMapper {
    User findOne(Integer id);
}
