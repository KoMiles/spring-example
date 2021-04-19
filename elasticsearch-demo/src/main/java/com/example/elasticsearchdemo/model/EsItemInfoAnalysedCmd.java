package com.example.elasticsearchdemo.model;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.util.StringUtils;

/**
 * @author komiles@163.com
 * @date 2021-04-19 20:42
 */
@Data
@NoArgsConstructor
public class EsItemInfoAnalysedCmd {
//    private Integer type;
//    private Integer dateFrom;
//    private Integer dateTo;
//    private List<String> sourceType;
//    private Integer salesVolumeFrom;
//    private Integer salesVolumeTo;
    private String name;

//    public EsItemInfoAnalysedCmd(String title, List<String> sourceType, Integer salesVolumeFrom,
//            Integer salesVolumeTo, Integer dateFrom, Integer dateTo) {
//            this.title = title;
//        this.sourceType = sourceType;
//        this.salesVolumeFrom = salesVolumeFrom;
//        this.salesVolumeTo = salesVolumeTo;
//        this.type = type;
//        this.dateFrom = dateFrom;
//        this.dateTo = dateTo;
//    }

    public EsItemInfoAnalysedCmd(String name) {
        this.name = name;
    }

    /**
     * JPA的复杂查询
     *
     * @return /
     */
    public Query buildQuery(Pageable pageable) {
            BoolQueryBuilder builder = QueryBuilders.boolQuery();
//        if (type != null) {
//                //term用来精确查询数字（numbers）、布尔值（Booleans）、日期（dates)
//                builder.must(QueryBuilders.termQuery("type", type));
//        }
//        //范围查询, between
//        if (dateFrom != null && dateTo != null) {
//                builder.must(QueryBuilders.rangeQuery("date").from(dateFrom).to(dateTo));
//        }
//        if (sourceType != null && sourceType.size() > 0) {
//                //terms用来查询文本或者多个值
//                builder.must(QueryBuilders.termsQuery("sourceType", toStringArray(sourceType)));
//        }
//        //销量xx以上, >=
//        if (salesVolumeFrom != null && salesVolumeTo == null) {
//                builder.must(QueryBuilders.rangeQuery("salesVolume").gte(salesVolumeFrom));
//        }
        //模糊查询, 只要是包换title的都返回
        if (!StringUtils.isEmpty(name)) {
                builder.must(QueryBuilders.matchQuery("name", name));
        }
        //构建查询语句
        return new NativeSearchQueryBuilder().withQuery(builder)
                .withPageable(pageable) //SpringBoot提供的分页参数
                .build();
    }

    private String[] toStringArray(List<String> sourceType) {
            String[] res = new String[sourceType.size()];
        for (int i = 0; i < sourceType.size(); i++) {
                res[i] = sourceType.get(i);
        }
        return res;
    }
}
