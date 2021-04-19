package com.example.elasticsearchstudy.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author komiles@163.com
 * @date 2021-04-18 23:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class User {
    private String name;

    private Integer age;

    private String title;
}
