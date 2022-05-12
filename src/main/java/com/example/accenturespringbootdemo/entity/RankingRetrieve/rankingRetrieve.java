package com.example.accenturespringbootdemo.entity.RankingRetrieve;

import java.util.List;
/**
 * 排行榜实体类。
 */
public class rankingRetrieve {

    //图书排行
    private List<bookRankingRetrieve> bookList;
    //用户排行
    private List<userRankingRetrieve> userList;

    public List<bookRankingRetrieve> getbookList() {
        return bookList;
    }

    public void setBookList(List<bookRankingRetrieve> bookList) {
        this.bookList = bookList;
    }

    public List<userRankingRetrieve> getuserList() {
        return userList;
    }

    public void setuserList(List<userRankingRetrieve> userList) {
        this.userList = userList;
    }


}
