package com.example.feigndemo.service;

import feign.Param;
import feign.RequestLine;
import org.springframework.stereotype.Component;

/**
 * @author komiles@163.com
 * @date 2020-09-10 11:06
 */
@Component
public interface RemoteService {

    @RequestLine("GET /users/list?name={name}")
    String getOwner(@Param(value = "name") String name);
}
