package com.example.elasticsearchdemo.controller;

import com.example.elasticsearchdemo.model.UserModel;
import com.example.elasticsearchdemo.model.UserTest2Model;
import com.example.elasticsearchdemo.model.UserTestModel;
import com.example.elasticsearchdemo.model.UserTestRepository;
import com.example.elasticsearchdemo.service.UserTestUpdateImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.UpdateQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author komiles@163.com
 * @date 2021-04-16 15:45
 */
@RestController
@RequestMapping("/userTest")
@Slf4j
public class UserTestController {
    @Autowired
    private UserTestRepository userRepository;

    @Autowired
    private UserTestUpdateImpl userUpdate;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;


    @PostMapping("/add")
    public String add(@RequestBody UserTestModel UserTestModel) {
        log.info("userTestModel:{}",UserTestModel.toString());
        userRepository.save(UserTestModel);
        return "OK";
    }

    @PostMapping("/addWithIndex")
    public String addWithIndex(@RequestBody UserTestModel userTestModel)
    {
//        List<IndexQuery> list = new ArrayList<>(100);
//        for (int i = 1; i <= 100; i++) {
//            IndexQuery indexQuery = new IndexQuery();
//            UseLogTwoDO useLogDO = UseLogTwoDO.builder().id(String.valueOf(i)).sortNo(i).result(String.format("我是%d号", i)).createTime(new Date()).build();
//            indexQuery.setId(useLogDO.getId());
//            indexQuery.setObject(useLogDO);
//            list.add(indexQuery);
//        }
//        List<String> strings = elasticsearchRestTemplate.bulkIndex(list, elasticsearchRestTemplate.getIndexCoordinatesFor(UseLogTwoDO.class));
//        System.out.println(strings);

        IndexQuery indexQuery = new IndexQuery();
        indexQuery.setId(userTestModel.getId().toString());
        indexQuery.setObject(userTestModel);
        elasticsearchRestTemplate.index(indexQuery,IndexCoordinates.of("student_test_1"));
        return "OK";
    }


    @PostMapping("/addWithIndex2")
    public String addWithIndex2(@RequestBody UserTest2Model userTestModel)
    {
//        List<IndexQuery> list = new ArrayList<>(100);
//        for (int i = 1; i <= 100; i++) {
//            IndexQuery indexQuery = new IndexQuery();
//            UseLogTwoDO useLogDO = UseLogTwoDO.builder().id(String.valueOf(i)).sortNo(i).result(String.format("我是%d号", i)).createTime(new Date()).build();
//            indexQuery.setId(useLogDO.getId());
//            indexQuery.setObject(useLogDO);
//            list.add(indexQuery);
//        }
//        List<String> strings = elasticsearchRestTemplate.bulkIndex(list, elasticsearchRestTemplate.getIndexCoordinatesFor(UseLogTwoDO.class));
//        System.out.println(strings);

        IndexQuery indexQuery = new IndexQuery();
        indexQuery.setId(userTestModel.getId().toString());
        indexQuery.setObject(userTestModel);
        elasticsearchRestTemplate.index(indexQuery,IndexCoordinates.of("student_test_1"));
        return "OK";
    }

    @GetMapping("/get/{id}")
    public UserTestModel getById(@PathVariable String id)
    {
        Optional<UserTestModel> UserTestModel = userRepository.findById(id);
        UserTestModel UserTestModelOne = UserTestModel.get();
        return UserTestModelOne;
    }

    @PostMapping("/update")
    public UserTestModel update(@RequestBody UserTestModel userTestUpdate)
    {
//        Document document = Document.create();
//        document.put("content", userTestModel.getContent());
//        document.put("title", userTestModel.getTitle());
//        UpdateQuery updateQuery = UpdateQuery.builder(userTestModel.getId().toString()).withDocument(document).build();
//        elasticsearchRestTemplate.update(updateQuery, IndexCoordinates.of("student_test_0"));

        userUpdate.updateData(userTestUpdate);
        Optional<UserTestModel> UserTestModelOptional = userRepository.findById(userTestUpdate.getId().toString());
        UserTestModel UserTestModelOne = UserTestModelOptional.get();
        return UserTestModelOne;
    }

    @GetMapping("updateList")
    public void updateList(){
        List<UpdateQuery> updateQueryList = new ArrayList<>();
        List<String> ids = new ArrayList<>();
        ids.add("2");
        ids.add("3");
        for (String id : ids) {
            Document document = Document.create();
            document.put("content", "我是更新后的内容"+id);
            document.put("title", "更新后的标题"+id);
            UpdateQuery updateQuery = UpdateQuery.builder(id).withDocument(document).build();
            updateQueryList.add(updateQuery);
        }
        elasticsearchRestTemplate.bulkUpdate(updateQueryList, IndexCoordinates.of("student_test_0"));
    }


    @PostMapping("/delete")
    public String deleteById(@RequestParam(value = "id") String id)
    {
        userRepository.deleteById(id);
        return "OK";
    }

    @GetMapping("/search")
    public  List<UserTestModel> search(@RequestParam("keyword") String keyword){
        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder()
                .withQuery(new MatchQueryBuilder("content", keyword))
                .withSort(new FieldSortBuilder("age").order(SortOrder.ASC))
                .build();

        SearchHits<UserTestModel> hits = elasticsearchRestTemplate
                .search(nativeSearchQuery, UserTestModel.class, IndexCoordinates.of("student_test_0"));

        List<UserTestModel> userModelList = new ArrayList<>();
        for (SearchHit<UserTestModel> hit : hits.getSearchHits()) {
            UserTestModel userModel = hit.getContent();
            userModelList.add(userModel);
            log.info("userModel:{}", userModel.toString());
        }
        return userModelList;
    }


}
