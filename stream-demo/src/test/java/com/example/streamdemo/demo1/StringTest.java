package com.example.streamdemo.demo1;

import com.alibaba.fastjson.JSONObject;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author komiles@163.com
 * @date 2020-05-17 23:05
 */
@SpringBootTest
public class StringTest {

    @Test
    public void hello(){
        List<String> strings = Arrays.asList("Hollis", "", "HollisChuang", "H", "hollis");

        List<String> result = strings.stream().filter(e->!e.isEmpty()).collect(Collectors.toList());
        System.out.println(JSONObject.toJSON(result));

        String resultStr = strings.stream().filter(e -> !e.isEmpty()).collect(Collectors.joining(","));
        System.out.println(JSONObject.toJSON(resultStr));
    }
}
