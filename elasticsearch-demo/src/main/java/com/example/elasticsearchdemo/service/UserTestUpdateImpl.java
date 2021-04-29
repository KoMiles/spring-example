package com.example.elasticsearchdemo.service;

import com.example.elasticsearchdemo.model.UserTestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.UpdateQuery;
import org.springframework.data.elasticsearch.core.query.UpdateResponse;
import org.springframework.stereotype.Service;

/**
 * @author komiles@163.com
 * @date 2021-04-28 18:17
 */
@Service
public class UserTestUpdateImpl implements UserTestUpdate {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;


    @Override
    public void updateContent(UserTestModel userTestModel, String content) {
        Document document = Document.create();
        document.put("content", content);
        UpdateQuery updateQuery = UpdateQuery.builder(userTestModel.getId().toString()).withDocument(document).build();
        UpdateResponse response = elasticsearchRestTemplate.update(updateQuery, IndexCoordinates.of("student_test_0"));
        System.out.println(response.getResult().toString());
    }

    @Override
    public void updateData(UserTestModel userTestModel) {
        Document document = Document.create();
        document.put("content", userTestModel.getContent());
        document.put("title", userTestModel.getTitle());
        UpdateQuery updateQuery = UpdateQuery.builder(userTestModel.getId().toString()).withDocument(document).build();
        elasticsearchRestTemplate.update(updateQuery, IndexCoordinates.of("student_test_0"));
    }
}
