package com.example.twodbdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// 去掉自动数据库自动配置类
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TwoDbDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwoDbDemoApplication.class, args);
        System.out.println("========= Two Db Demo Application End ============");
    }

}
