package com.example.streamdemo.demo;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author komiles@163.com
 * @date 2020-05-21 17:41
 */
@SpringBootTest
public class Demo0521 {

    /**
     * 需要打印出其中所有长度大于3的字符串.
     */
    @Test
    public void test()
    {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I","love","you","too"));
        // java 7 之前的操作
//        for (String str:list
//        ) {
//            if(str.length()>3){
//                System.out.println(str);
//            }
//        }
        // java 8 之后的操作
        list.stream().forEach(s -> {
            if(s.length()>3) {
                System.out.println(s);
            } }
        );

    }


    /**
     * 需要打印出其中最大值和最小值
     */
    @Test
    public void test2()
    {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,99,100,999));

        Integer maxNum = list.stream().max(Integer::compareTo).get();
        System.out.println("最大值为"+maxNum+"\n");
        Integer minNum = list.stream().min(Integer::compareTo).get();
        System.out.println("最小值为"+minNum+"\n");
    }


    /**
     * 过滤空字符串
     */
    @Test
    public void test3()
    {
        List<String> strings = Arrays.asList("Hollis", "", "HollisChuang", "H", "hollis");

        List<String> result = strings.stream().filter(e->!e.isEmpty()).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(result));
    }

    /**
     * 过滤空字符串，并把数组中的值拼接成字符串
     */
    @Test
    public void test4()
    {
        List<String> strings = Arrays.asList("Hollis", "", "HollisChuang", "H", "hollis");
        String result = strings.stream().filter(e->!e.isEmpty()).collect(Collectors.joining(","));
        System.out.println(result);
    }
}
