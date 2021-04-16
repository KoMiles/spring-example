package com.example.elasticsearchdemo.service;

import com.example.elasticsearchdemo.bean.PageDTO;
import com.example.elasticsearchdemo.model.UserModel;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author komiles@163.com
 * @date 2021-04-16 21:29
 */
public interface UserService {

    PageDTO<UserModel> search(QueryBuilder queryBuilder, Pageable pageable);
}
