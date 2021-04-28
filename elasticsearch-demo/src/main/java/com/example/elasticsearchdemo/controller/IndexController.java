package com.example.elasticsearchdemo.controller;

import com.example.elasticsearchdemo.model.UserTestModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author komiles@163.com
 * @date 2021-04-28 17:41
 */
@RestController
@Slf4j
public class IndexController {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @GetMapping("/createIndex")
    public String createIndex()
    {
        elasticsearchRestTemplate.createIndex(UserTestModel.class);

        elasticsearchRestTemplate.putMapping(UserTestModel.class);

        return "OK";
    }
}
