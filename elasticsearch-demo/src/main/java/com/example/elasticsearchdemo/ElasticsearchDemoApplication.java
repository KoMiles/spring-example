package com.example.elasticsearchdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ElasticsearchDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(ElasticsearchDemoApplication.class, args);

        System.out.println("============ Application End ============");
    }

}
