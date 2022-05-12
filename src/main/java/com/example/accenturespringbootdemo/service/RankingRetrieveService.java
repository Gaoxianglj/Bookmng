package com.example.accenturespringbootdemo.service;

import com.example.accenturespringbootdemo.entity.RankingRetrieve.rankingRetrieve;

import java.util.List;
/**
 * 借阅排行榜业务接口。
 */
public interface RankingRetrieveService {
    /**
     * 借阅排行榜。
     *
     * @return 排行榜
     */
    public rankingRetrieve RankingRetrieve();
}
