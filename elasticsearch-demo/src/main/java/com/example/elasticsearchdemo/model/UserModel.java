package com.example.elasticsearchdemo.model;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author komiles@163.com
 * @date 2021-04-16 15:38
 */
@Data
@Accessors(chain = true)
@Document(indexName = "student-20210416", type = "first")
public class UserModel implements Serializable {

    private String age;

    private String name;

    private String title;

    private String ctime;

    private String utime;

    private Integer id;
}
