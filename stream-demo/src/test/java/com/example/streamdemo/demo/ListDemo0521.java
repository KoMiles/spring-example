package com.example.streamdemo.demo;

/**
 * @author komiles@163.com
 * @date 2020-05-21 18:18
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * 初始化List 集合的6种方式
 */
public class ListDemo0521 {

    /**
     * 第一种方式
     * 常规方式
     */
    @Test
    public void one(){
        List<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("PHP");
        languages.add("Python");
        System.out.println(languages);
    }

    /**
     * 第二种方式
     * Arrays工具类
     */
    @Test
    public void two(){
        List<String> languages = new ArrayList<>(Arrays.asList("Java1","PHP1","Python1"));
        System.out.println(languages);
    }

    /**
     * 第三种方式
     * Collections工具类
     */
    @Test
    public void three(){
        List<String> apples = Collections.nCopies(3,"apple");
        System.out.println(apples);
    }

    /**
     * 第四种方式 匿名内部类
     */
    @Test
    public void four(){
        List<String> names = new ArrayList() {{
            add("Tom");
            add("Sally");
            add("John");
        }};
        System.out.println(names);
    }

    /**
     * 第五种方式 jdk8 Stream
     */
    @Test
    public void five(){
        List<String> colors = Stream.of("blue","red","yellow").collect(Collectors.toList());
        System.out.println(colors);
    }

}
