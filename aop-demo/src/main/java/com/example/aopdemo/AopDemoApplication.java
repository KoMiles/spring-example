package com.example.aopdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopDemoApplication {

    public static void main(String[] args) {
        System.out.println("======== Aop demo Application start ========");
        SpringApplication.run(AopDemoApplication.class, args);
        System.out.println("======== Aop demo Application End ========");
    }

}
