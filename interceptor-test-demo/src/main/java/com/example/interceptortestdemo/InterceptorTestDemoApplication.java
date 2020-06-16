package com.example.interceptortestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InterceptorTestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterceptorTestDemoApplication.class, args);
        System.out.println("============== Spring Application End ================");
    }

}
