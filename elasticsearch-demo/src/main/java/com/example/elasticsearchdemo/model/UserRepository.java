package com.example.elasticsearchdemo.model;

import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author komiles@163.com
 * @date 2021-04-16 15:44
 */
public interface UserRepository extends ElasticsearchRepository<UserModel, String> {
//    List<UserModel> findByNameLike(String title);
    UserModel queryById(Integer id);
}

