package com.example.streamdemo.demo;

import java.util.stream.Stream;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author komiles@163.com
 * @date 2020-05-19 17:49
 */
@SpringBootTest
public class Stream0519 {

    @Test
    public void init(){
        Stream stream = Stream.of("a", "b", "c");

        stream.forEach(System.out::println);
    }
}
