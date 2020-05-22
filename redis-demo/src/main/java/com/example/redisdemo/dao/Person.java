package com.example.redisdemo.dao;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author komiles@163.com
 * @date 2020-05-22 15:11
 */
@Data
@Accessors(chain = true)
public class Person implements Serializable {

    private static final Long serialVersionUID = 99999L;

    private String id;

    private String name;
}
