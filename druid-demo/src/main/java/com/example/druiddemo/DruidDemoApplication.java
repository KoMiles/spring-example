package com.example.druiddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 去掉自动数据库自动配置类
 * @author komiles@163.com
 * @date 2020-05-12 18:41
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DruidDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DruidDemoApplication.class, args);
        System.out.println("============= druid-demo application start =============");
    }

}
