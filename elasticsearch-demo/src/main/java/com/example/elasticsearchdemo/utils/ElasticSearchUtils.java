package com.example.elasticsearchdemo.utils;

import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import javax.annotation.Resource;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Component;

/**
 * @author komiles@163.com
 * @date 2021-04-19 14:55
 */
@Component
@Slf4j
public class ElasticSearchUtils {
    @Resource
    private RestHighLevelClient restHighLevelClient ;

    /**
     * description: 多字段匹配查询
     * @author karma
     * @param index 索引
     * @param fieldMap 字段map集合
     * @return java.lang.String
     * @date 2019/11/27 3:47 下午
     **/
    public String getByMultiFieldNames(String index, Map<String,Object> fieldMap) throws IOException {
        if(StringUtils.isBlank(index) || MapUtils.isEmpty(fieldMap)){
            return null;
        }
        SearchRequest searchRequest = new SearchRequest(index);

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        //循环传入搜索参数
        fieldMap.forEach((key, value) ->{
            boolQueryBuilder.must(QueryBuilders.termQuery(key,value));
        });

        sourceBuilder.query(boolQueryBuilder);
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        return handleSearchResponse2Json(searchResponse);
    }


    /**
     * description: 根据id 查询
     * @author karma
     * @param index 索引
     * @param id (es数据id  _id)
     * @return java.lang.String
     * @date 2019/11/25 1:53 下午
     **/
    public String getByIndexAndId(String index, String id)throws IOException{
        if(StringUtils.isBlank(index) || StringUtils.isBlank(id)){
            return null;
        }
//        GetIndexRequest getIndexRequest = new GetIndexRequest(index,id);
//        GetIndexResponse getIndexResponse = restHighLevelClient.indices().
//
//                IndexRequest request = new IndexRequest("chen_index");
//        // 规则 put /chen_index/_doc/1
//        request.id("2");
//        request.timeout(TimeValue.timeValueSeconds(1));
//        // request.timeout("1s");
//
//        // 将我们的数据放入请求 这里需要导入我们的json依赖包,真实项目不建议使用fastjson
//        request.source(JSON.toJSONString(user), XContentType.JSON);
//
//        // 客户端发送请求
//        IndexResponse index = client.index(request, RequestOptions.DEFAULT);

        GetRequest getRequest = new GetRequest(index,id);
        GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        log.info("==========response:{}========",getResponse.getSourceAsString());
        return getResponse.getSourceAsString();
    }

    /**
     * description: 根据索引查询
     * @author karma
     * @param index 索引
     * @param pageNum 第几页
     * @param pageSize 每页条数
     * @return java.lang.String
     * @date 2019/11/25 1:54 下午
     **/
    public String getByIndex(String index, int pageNum, int pageSize)throws IOException{
        if(StringUtils.isBlank(index)){
            return null;
        }

        // 搜索请求
        SearchRequest searchRequest = new SearchRequest(index);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        // 分页
        if(pageNum >= 0 && pageSize >= 0){
            searchSourceBuilder.from(pageSize*(pageNum - 1));
            searchSourceBuilder.size(pageSize);
        }else {
            // 如果不传分页参数 默认给20条数据
            searchSourceBuilder.from(0);
            searchSourceBuilder.size(19);
        }

        // 查询条件
        MatchAllQueryBuilder queryBuilder = QueryBuilders.matchAllQuery();

        // 传入搜索条件
        searchSourceBuilder.query(queryBuilder);
        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = restHighLevelClient.search(searchRequest,RequestOptions.DEFAULT);
        return handleSearchResponse2Json(searchResponse);
    }


    /**
     * description: 根据字段查询
     * @author karma
     * @param index 索引
     * @param fileName 字段名
     * @param value 字段值
     * @return java.lang.String
     * @date 2019/11/27 4:00 下午
     **/
    public String getByFieldName(String index, String fileName,String value) throws IOException{

        if(StringUtils.isBlank(index) || StringUtils.isBlank(fileName) || StringUtils.isBlank(value)){
            return null;
        }

        SearchRequest searchRequest = new SearchRequest(index);

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        QueryBuilder queryBuilder = QueryBuilders.matchQuery(fileName,value);
        sourceBuilder.query(queryBuilder);

        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest,RequestOptions.DEFAULT);
        return handleSearchResponse2Json(searchResponse);
    }



    /**
     * description: 将SearchResponse 取出数据 转换成json
     * @author karma
     * @param searchResponse
     * @return java.lang.String
     * @date 2019/11/27 2:33 下午
     **/
    private String handleSearchResponse2Json(SearchResponse searchResponse){

        SearchHit[] hits = searchResponse.getHits().getHits();

        if(hits.length == 0){
            return null;
        }

        List<Map<String,Object>> dataList = new ArrayList<>(hits.length);
        for(int i=0; i< hits.length; i++){
            dataList.add(hits[i].getSourceAsMap());
        }
        return JSONObject.toJSONString(dataList);
    }
}
