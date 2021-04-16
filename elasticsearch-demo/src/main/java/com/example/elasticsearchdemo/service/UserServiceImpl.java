package com.example.elasticsearchdemo.service;

import com.example.elasticsearchdemo.bean.PageDTO;
import com.example.elasticsearchdemo.model.UserModel;
import com.example.elasticsearchdemo.model.UserRepository;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author komiles@163.com
 * @date 2021-04-16 21:48
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService{
//    @Override
//    public PageDTO<RoomIndexDTO> search(QueryBuilder queryBuilder, Pageable pageable) {
//        Page<RoomIndexPO> roomIndexPOPage = roomIndexRepository.search(queryBuilder, pageable);
//        log.info("return search: {}", roomIndexPOPage);
//        List<RoomIndexPO> roomIndexPOList = roomIndexPOPage.toList();
//        List<RoomIndexDTO> roomIndexDTOList = roomIndexPOList.stream().map(roomIndexPO -> {
//            return BeanMapperUtil.map(roomIndexPO, RoomIndexPO.class, RoomIndexDTO.class);
//        }).collect(Collectors.toList());
//
//        com.github.pagehelper.Page page = new com.github.pagehelper.Page();
//        page.setPageSize(pageable.getPageSize()).setPageNum(pageable.getPageNumber()).setTotal(roomIndexPOPage.getTotalElements());
//        return new PageDTO(page, roomIndexDTOList);
//    }
    @Resource
    private UserRepository userRepository;


    @Override
    public PageDTO<UserModel> search(QueryBuilder queryBuilder, Pageable pageable) {

        Page<UserModel> userModelPage = userRepository.search(queryBuilder,pageable);
        log.info("======= page:{}",userModelPage.toString());
        List<UserModel> userModelList = userModelPage.toList();

        com.github.pagehelper.Page page = new com.github.pagehelper.Page();

        return new PageDTO(page, userModelList);
    }
}
