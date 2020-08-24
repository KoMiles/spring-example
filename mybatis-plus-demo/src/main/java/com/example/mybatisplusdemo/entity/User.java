package com.example.mybatisplusdemo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author kongming
 * @since 2020-08-24
 */
@Data
public class User {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;


}
