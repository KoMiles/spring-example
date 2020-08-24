package com.example.mybatisplusdemo.mappertest;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.mybatisplusdemo.dao.User;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author komiles@163.com
 * @date 2020-08-24 18:11
 */
public interface UserMapper extends BaseMapper<User> {

    @Override
    int insert(User entity);

    @Override
    int deleteById(Serializable id);

    @Override
    int deleteByMap(Map<String, Object> columnMap);

    @Override
    int delete(Wrapper<User> wrapper);

    @Override
    int deleteBatchIds(Collection<? extends Serializable> idList);

    @Override
    int updateById(User entity);

    @Override
    int update(User entity, Wrapper<User> updateWrapper);

    @Override
    User selectById(Serializable id);

    @Override
    List<User> selectBatchIds(Collection<? extends Serializable> idList);

    @Override
    List<User> selectByMap(Map<String, Object> columnMap);

    @Override
    User selectOne(Wrapper<User> queryWrapper);

    @Override
    Integer selectCount(Wrapper<User> queryWrapper);

    @Override
    List<User> selectList(Wrapper<User> queryWrapper);

    @Override
    List<Map<String, Object>> selectMaps(Wrapper<User> queryWrapper);

    @Override
    List<Object> selectObjs(Wrapper<User> queryWrapper);

    @Override
    <E extends IPage<User>> E selectPage(E page, Wrapper<User> queryWrapper);

    @Override
    <E extends IPage<Map<String, Object>>> E selectMapsPage(E page, Wrapper<User> queryWrapper);
}
