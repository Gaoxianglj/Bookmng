package com.example.accenturespringbootdemo.service.impl;

import com.example.accenturespringbootdemo.entity.RankingRetrieve.rankingRetrieve;
import com.example.accenturespringbootdemo.repository.BorrowHistoryRepository;
import com.example.accenturespringbootdemo.service.RankingRetrieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
/**
 * 排行榜业务实现层。
 */
@Service
public class RankingRetrieveServiceImpl implements RankingRetrieveService {
    @Resource
    BorrowHistoryRepository borrowHistoryRepository;
    /**
     * 借阅排行榜。
     *
     * @return 排行榜
     */
    @Override
    public rankingRetrieve RankingRetrieve() {
        rankingRetrieve rankingRetrieve=new rankingRetrieve();
        rankingRetrieve.setBookList(borrowHistoryRepository.BookRetrieve());
        System.out.println("书名"+borrowHistoryRepository.BookRetrieve().get(0).getBookName());
        rankingRetrieve.setuserList(borrowHistoryRepository.UserRetrieve());
        return rankingRetrieve;
    }
}
