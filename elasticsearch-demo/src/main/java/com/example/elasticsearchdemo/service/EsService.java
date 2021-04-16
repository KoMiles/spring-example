package com.example.elasticsearchdemo.service;

import com.example.elasticsearchdemo.Dao.OrgDao;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilterBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.core.query.SourceFilter;
import org.springframework.stereotype.Service;

/**
 * @author komiles@163.com
 * @date 2021-04-16 11:06
 */
@Service
@Slf4j
public class EsService {
    @Resource
    private ElasticsearchRestTemplate elasticsearchTemplate;

    public List<OrgDao> queryAll(String userId)
    {

        String[] includes = new String[] {
                "user_id"
//                ,"user_name"
        };
        Pageable pageable = PageRequest.of(0,10);

        SourceFilter sourceFilter = new FetchSourceFilterBuilder().withIncludes(includes).build();
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withSourceFilter(sourceFilter)
                // 添加查询条件
                .withQuery(QueryBuilders.termsQuery("user_id",userId)).withPageable(pageable)
                .build();
        log.info("search Query:{}",searchQuery);
        List<OrgDao> OrgList = elasticsearchTemplate.queryForList(searchQuery, OrgDao.class);
        return OrgList;
    }
}
