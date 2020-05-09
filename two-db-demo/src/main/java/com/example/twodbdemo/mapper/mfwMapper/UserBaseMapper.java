package com.example.twodbdemo.mapper.mfwMapper;

import com.example.twodbdemo.dao.mfwDao.UserBase;
import com.example.twodbdemo.dao.mfwDao.UserBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserBaseMapper {
    long countByExample(UserBaseExample example);

    int deleteByExample(UserBaseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserBase record);

    int insertSelective(UserBase record);

    List<UserBase> selectByExample(UserBaseExample example);

    UserBase selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserBase record, @Param("example") UserBaseExample example);

    int updateByExample(@Param("record") UserBase record, @Param("example") UserBaseExample example);

    int updateByPrimaryKeySelective(UserBase record);

    int updateByPrimaryKey(UserBase record);
}