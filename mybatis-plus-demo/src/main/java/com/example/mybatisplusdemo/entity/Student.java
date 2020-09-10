package com.example.mybatisplusdemo.entity;

import 你自己的父类实体,没有就不用设置!;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author kongming
 * @since 2020-08-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Student extends 你自己的父类实体,没有就不用设置! {

    private static final long serialVersionUID = 1L;

    @TableField("studentID")
    private Integer studentID;

    private String name;


}
