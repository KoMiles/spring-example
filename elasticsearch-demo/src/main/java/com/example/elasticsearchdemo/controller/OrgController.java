package com.example.elasticsearchdemo.controller;

import com.example.elasticsearchdemo.Dao.OrgDao;
import com.example.elasticsearchdemo.service.EsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author komiles@163.com
 * @date 2021-04-16 11:54
 */
@RestController
@RequestMapping("/org")
public class OrgController {
    @Autowired
    EsService esService;

//    @GetMapping("/list")
//    public List<OrgDao> getOrgList(@RequestParam String userId)
//    {
//        List<OrgDao> orgDaoList = esService.queryAll(userId);
//        return orgDaoList;
//    }
}
