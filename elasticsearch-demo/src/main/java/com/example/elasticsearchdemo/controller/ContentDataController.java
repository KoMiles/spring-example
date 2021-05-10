package com.example.elasticsearchdemo.controller;

import com.example.elasticsearchdemo.model.ContentDataModel;
import com.example.elasticsearchdemo.model.UserTestModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author komiles@163.com
 * @date 2021-05-07 20:57
 */
@RestController
@RequestMapping("/cdp")
@Slf4j
public class ContentDataController {
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @GetMapping("/createIndex")
    public String createIndex()
    {
        elasticsearchRestTemplate.indexOps(ContentDataModel.class);
        return "OK";
    }

    @PostMapping("/add")
    public String addData(@RequestBody ContentDataModel contentDataModel)
    {

        IndexQuery indexQuery = new IndexQuery();
        String id = contentDataModel.getBizType().toString() +  contentDataModel.getBizType().toString();
        indexQuery.setId(id);
        indexQuery.setObject(contentDataModel);
        elasticsearchRestTemplate.index(indexQuery, IndexCoordinates.of("student_test_1"));
        return "OK";
    }
}
