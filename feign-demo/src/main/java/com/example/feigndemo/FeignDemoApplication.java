package com.example.feigndemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FeignDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignDemoApplication.class, args);
		System.out.println("=========== Application End =========");
	}

}
