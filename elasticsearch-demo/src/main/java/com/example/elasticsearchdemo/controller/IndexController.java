package com.example.elasticsearchdemo.controller;

import com.example.elasticsearchdemo.model.UserTest2Model;
import com.example.elasticsearchdemo.model.UserTestModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
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
        elasticsearchRestTemplate.indexOps(UserTestModel.class);
//        elasticsearchRestTemplate.createIndex(UserTestModel.class);
//        elasticsearchRestTemplate.putMapping(UserTestModel.class);

        return "OK";
    }
    @GetMapping("/updateIndex")
    public String updateIndex()
    {
        elasticsearchRestTemplate.indexOps(UserTest2Model.class);
//        elasticsearchRestTemplate.createIndex(UserTestModel.class);
//
//        elasticsearchRestTemplate.putMapping(UserTestModel.class);

        return "OK";
    }

}
