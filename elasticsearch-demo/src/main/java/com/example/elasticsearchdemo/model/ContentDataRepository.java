package com.example.elasticsearchdemo.model;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.example.elasticsearchdemo.model.ContentDataModel;

/**
 * @author komiles@163.com
 * @date 2021-04-16 15:44
 */
public interface ContentDataRepository extends ElasticsearchRepository<ContentDataModel, String> {

}

