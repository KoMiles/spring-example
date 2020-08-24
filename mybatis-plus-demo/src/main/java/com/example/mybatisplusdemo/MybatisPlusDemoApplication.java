package com.example.mybatisplusdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mybatisplusdemo.mapper")
public class MybatisPlusDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(MybatisPlusDemoApplication.class, args);
		System.out.println("========= Application mybatis-plus End ==========");
	}

}
