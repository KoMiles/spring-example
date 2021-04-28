package com.example.elasticsearchdemo.controller;

import com.alibaba.fastjson.JSON;
import com.example.elasticsearchdemo.model.UserModel;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ES 索引配置
 * @author komiles@163.com
 * @date 2021-04-19 18:33
 */
@RequestMapping("/search")
@RestController
@Slf4j
public class SearchController {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @GetMapping("/count")
    public long getCount(@RequestParam String keyword) {

        NativeSearchQueryBuilder searchQueryBuilder = new NativeSearchQueryBuilder();
        long count = elasticsearchRestTemplate.count(searchQueryBuilder.build(), IndexCoordinates.of("student"));
        log.info("count -> {}", count);
        return count;
    }

    @GetMapping("/list")
    public List<UserModel> getList1(@RequestParam String keyword) {
        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder()
                .withQuery(new MatchQueryBuilder("name", keyword))
                //.withSort(new FieldSortBuilder("publishDate").order(SortOrder.DESC))
                .build();

        SearchHits<UserModel> hits = elasticsearchRestTemplate
                .search(nativeSearchQuery, UserModel.class, IndexCoordinates.of("student"));

        List<UserModel> userModelList = new ArrayList<>();
        for (SearchHit<UserModel> hit : hits.getSearchHits()) {
            UserModel userModel = hit.getContent();
            userModelList.add(userModel);
            log.info("userModel:{}", userModel.toString());
        }
        return userModelList;

    }



}
