package com.example.elasticsearchdemo.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * 更新之后的索引
 * @author komiles@163.com
 * @date 2021-04-28 17:43
 */

@Data
@Builder
@Document(indexName = "student_test_1")
@AllArgsConstructor
@NoArgsConstructor
public class UserTest2Model implements Serializable {

    @Field(type = FieldType.Integer)
    private String age;

    @Field(type = FieldType.Keyword)
    private String name;

    @Field(type = FieldType.Keyword)
    private String title;

    @Field(type = FieldType.Long)
    private String ctime;

    @Field(type = FieldType.Long)
    private String utime;

    @Field(type = FieldType.Text)
    private String content;

    @Field(type = FieldType.Keyword)
    private String tag;

    @Id
    private Long id;
}
