package com.example.elasticsearchstudy.controller;

import com.alibaba.fastjson.JSON;
import com.example.elasticsearchstudy.Model.User;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author komiles@163.com
 * @date 2021-04-18 23:13
 */
@RestController
@RequestMapping("/es")
@Slf4j
public class EsController {

    @Autowired
    private RestHighLevelClient client;

    @GetMapping("/createIndex")
    public String createIndex () throws IOException
    {
        // 1、创建索引请求
        CreateIndexRequest request = new CreateIndexRequest("chen_index");
        // 2、客户端执行创建请求 IndicesClient,请求后获得相应
        CreateIndexResponse createIndexResponse =
                client.indices().create(request, RequestOptions.DEFAULT);

        return "OK";
    }

    @GetMapping("/getIndex")
    public Boolean getIndex() throws IOException
    {
        GetIndexRequest request = new GetIndexRequest("chen_index");
        boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
        return exists;
    }


    @GetMapping("/add")
    public String addDocument() throws IOException
    {
        User user = new User("kongming2", 30,"我是中国人2");
        // 创建请求
        IndexRequest request = new IndexRequest("chen_index");
        // 规则 put /chen_index/_doc/1
        request.id("2");
        request.timeout(TimeValue.timeValueSeconds(1));
        // request.timeout("1s");

        // 将我们的数据放入请求 这里需要导入我们的json依赖包,真实项目不建议使用fastjson
        request.source(JSON.toJSONString(user), XContentType.JSON);

        // 客户端发送请求
        IndexResponse index = client.index(request, RequestOptions.DEFAULT);

        log.info("index:{}",index.toString());
        log.info("status:{}",index.status());
        return "OK";
    }
    @GetMapping("/update")
    public String updateDocument() throws IOException
    {
        UpdateRequest request = new UpdateRequest("chen_index", "1");
        request.timeout("1s");

        User user = new User("李四",66,"我是日本人");
        request.doc(JSON.toJSONString(user),XContentType.JSON);

        UpdateResponse update = client.update(request, RequestOptions.DEFAULT);
        log.info("index:{}",update.toString());
        log.info("status:{}",update.status());
        return "OK";
    }


    @GetMapping("/search")
    public String search() throws IOException
    {
        SearchRequest request = new SearchRequest("chen_index");
        // 构建搜索条件
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        // 查询条件，我们可以用QueryBuilders工具类来实现

        // QueryBuilders.termQuery 精确
        // QueryBuilders.matchAllQuery() 匹配所有
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "kongming2");
        // MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
        sourceBuilder.query(termQueryBuilder);
        // sourceBuilder.from();
        // sourceBuilder.size();
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        request.source(sourceBuilder);

        SearchResponse searchResponse = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = searchResponse.getHits();
        System.out.println(JSON.toJSONString(hits));
        System.out.println("============================");
        for (SearchHit hit : hits.getHits()) {
            System.out.println(hit.getSourceAsMap());
        }
        return "OK";
    }
}
