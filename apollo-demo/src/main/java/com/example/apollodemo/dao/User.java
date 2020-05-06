package com.example.apollodemo.dao;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author komiles@163.com
 * @date 2020-05-06 17:14
 */
@Data
@Accessors(chain = true)
public class User {

    private Integer id;

    private String name;

    private String password;

    private Integer age;
}
