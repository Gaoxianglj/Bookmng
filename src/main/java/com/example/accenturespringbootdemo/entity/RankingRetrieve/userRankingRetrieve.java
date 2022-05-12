package com.example.accenturespringbootdemo.entity.RankingRetrieve;
/**
 * 排行榜（用户）实体类。
 */
public class userRankingRetrieve {
    //用户名
    String userName;
    //借阅数量
    Integer borrowCount;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getBorrowCount() {
        return borrowCount;
    }

    public void setBorrowCount(Integer borrowCount) {
        this.borrowCount = borrowCount;
    }


}
