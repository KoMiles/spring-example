package com.example.pagehelperdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.pagehelperdemo.mappertest")
public class PageHelperDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PageHelperDemoApplication.class, args);
		System.out.println("=========== page-helper-demo end ============");
	}

}
