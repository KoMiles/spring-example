package com.example.interceptortestdemo.dao;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author komiles@163.com
 * @date 2020-06-19 19:09
 */
@Data
@Accessors(chain = true)
public class UserDao {

    private Integer userId;

    private String userName;

    private String password;


}
