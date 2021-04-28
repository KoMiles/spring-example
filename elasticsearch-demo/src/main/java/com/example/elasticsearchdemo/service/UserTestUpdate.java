package com.example.elasticsearchdemo.service;

import com.example.elasticsearchdemo.model.UserTestModel;

/**
 * @author komiles@163.com
 * @date 2021-04-28 18:16
 */
public interface UserTestUpdate {

    public void updateContent(UserTestModel userTestModel, String content);
}
