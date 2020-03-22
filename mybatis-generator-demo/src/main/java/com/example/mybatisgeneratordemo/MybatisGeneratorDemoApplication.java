package com.example.mybatisgeneratordemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mybatisgeneratordemo.mapper")
public class MybatisGeneratorDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisGeneratorDemoApplication.class, args);
    }

}
