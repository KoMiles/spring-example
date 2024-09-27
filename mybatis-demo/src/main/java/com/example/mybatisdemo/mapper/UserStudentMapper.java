package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.domain.UserStudent;
import java.util.List;

public interface UserStudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserStudent record);

    UserStudent selectByPrimaryKey(Integer id);

    List<UserStudent> selectAll();

    int updateByPrimaryKey(UserStudent record);
}