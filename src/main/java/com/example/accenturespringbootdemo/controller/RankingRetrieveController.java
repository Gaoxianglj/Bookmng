package com.example.accenturespringbootdemo.controller;

import com.example.accenturespringbootdemo.entity.RankingRetrieve.rankingRetrieve;
import com.example.accenturespringbootdemo.service.RankingRetrieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RankingRetrieveController {
   @Resource
    RankingRetrieveService rankingRetrieveService;
    /**
     * 排行榜管理。
     * <p>给出用户借阅量和图书借阅量的排行</p>
     *
     * @return 用户借阅list（按照借阅量排名），图书借阅list（按借阅量排名）。
     */
    @PostMapping("/ranking/retrieve")
    public rankingRetrieve RankingRetrieve(){
        return rankingRetrieveService.RankingRetrieve();
    }
}
