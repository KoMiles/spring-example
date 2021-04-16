package com.example.elasticsearchdemo.controller;

import com.example.elasticsearchdemo.bean.PageDTO;
import com.example.elasticsearchdemo.model.UserModel;
import com.example.elasticsearchdemo.model.UserRepository;
import com.example.elasticsearchdemo.service.UserServiceImpl;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private UserService userService;
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/add")
    public String add(@RequestBody UserModel userModel) {
        log.info("userModel:{}",userModel.toString());
        userRepository.save(userModel);
        return "OK";
    }


    @GetMapping("/get/{id}")
    public UserModel getById(@PathVariable String id)
    {
        Optional<UserModel> userModel = userRepository.findById(id);
        UserModel userModelOne = userModel.get();
        return userModelOne;
    }

    @PostMapping("/update")
    public UserModel update(@RequestBody UserModel userModel)
    {
        Integer id = userModel.getId();
        userRepository.save(userModel);
        Optional<UserModel> userModelOptional = userRepository.findById(id.toString());
        UserModel userModelOne = userModelOptional.get();
        return userModelOne;
    }


    @PostMapping("/delete/{id}")
    public String deleteById(@PathVariable String id)
    {
        userRepository.deleteById(id);
        return "OK";
    }


    @GetMapping("/list")
    public List<UserModel>  getUserList(@RequestParam String keyword)
    {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//        if(!Objects.isNull(adminSearchRoomParam.getRoomId())) {
//            boolQueryBuilder.must(QueryBuilders.termQuery("roomId", adminSearchRoomParam.getRoomId()));
//        }
//        if(!Objects.isNull(adminSearchRoomParam.getRoomTitle())) {
//            boolQueryBuilder.must(QueryBuilders.wildcardQuery("name.keyword", "*"+adminSearchRoomParam.getRoomTitle()+"*"));
//        }
//        if(!Objects.isNull(adminSearchRoomParam.getAnchorName())) {
//            boolQueryBuilder.must(QueryBuilders.wildcardQuery("anchorName.keyword", "*"+adminSearchRoomParam.getAnchorName()+"*"));
//        }
//        if(!Objects.isNull(adminSearchRoomParam.getType())) {
//            boolQueryBuilder.must(QueryBuilders.termQuery("status", adminSearchRoomParam.getType()));
//        }
//        boolQueryBuilder.

//        boolQueryBuilder.must(QueryBuilders.wildcardQuery("title", "*"+keyword+"*"));
//        boolQueryBuilder.must(QueryBuilders.matchPhraseQuery("title", "*"+keyword+"*"));
//        boolQueryBuilder.must(QueryBuilders.matchPhraseQuery("title", keyword));
//        boolQueryBuilder.must(QueryBuilders.wildcardQuery("title", "*"+keyword+"*"));

//        Pageable pageable = PageRequest.of(0, 10);
//        String keyword[] = ke
//        Page<UserModel> userModelPage = userRepository.searchSimilar("name",[keyword], pageable);
        List<UserModel> userModelList = userRepository.findByNameLike(keyword);
        return userModelList;
    }

    @GetMapping("/search")
    public PageDTO<UserModel> getSearchList(@RequestParam String keyword)
    {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//        boolQueryBuilder.must(QueryBuilders.matchPhraseQuery("title", "*"+keyword+"*"));
        boolQueryBuilder.must(QueryBuilders.termQuery("name", keyword));
        PageDTO<UserModel> userModelPageDTO = userService.search(boolQueryBuilder, PageRequest.of(0, 10));
        return userModelPageDTO;
    }

}
