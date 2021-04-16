package com.example.elasticsearchdemo.Dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author komiles@163.com
 * @date 2021-04-16 11:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrgDao {

    private String orgId;

    private String orgName;

    private String userId;

    private String userName;

    private String title;

    private String content;

    private Integer type;

    private Integer status;

    private Integer addType;

    private String ctime;

    private String mtime;

    private Integer id;


}
