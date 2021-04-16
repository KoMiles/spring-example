package com.example.elasticsearchdemo.model;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author komiles@163.com
 * @date 2021-04-16 15:44
 */
public interface UserRepository extends ElasticsearchRepository<UserModel, String> {
}

