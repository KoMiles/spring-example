package com.example.elasticsearchdemo.config;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

/**
 * @author komiles@163.com
 * @date 2021-04-16 11:08
 */
@Configuration
public class EsConfig {
    @Value("${es.host}")
    public String host;
    @Value("${es.port}")
    public int port;

    @Bean
    public RestHighLevelClient elasticsearchClient() {
        List<HttpHost> hostList = new ArrayList<>();
        String[] hosts = host.split(",");
        for (String hostItem : hosts) {
            hostList.add(new HttpHost(hostItem, port));
        }
        RestClientBuilder builder = RestClient.builder(hostList.toArray(new HttpHost[0]));
        return new RestHighLevelClient(builder);
    }

    @Bean
    public ElasticsearchRestTemplate elasticsearchTemplate() {
        return new ElasticsearchRestTemplate(elasticsearchClient());
    }
}
