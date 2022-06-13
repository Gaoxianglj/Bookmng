package com.example.accenturespringbootdemo.entity.RankingRetrieve;
/**
 * 排行榜（图书）实体类。
 */
public class bookRankingRetrieve {
    //图书名
    private String bookName;
    //作者名
    private String authorName;
    //借阅次数
    private Integer borrowCount;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer getBorrowCount() {
        return borrowCount;
    }

    public void setBorrowCount(Integer borrowCount) {
        this.borrowCount = borrowCount;
    }
}
