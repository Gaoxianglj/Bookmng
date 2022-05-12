package com.example.accenturespringbootdemo.entity.RankingRetrieve;
/**
 * 排行榜（图书）实体类。
 */
public class bookRankingRetrieve {
    //图书名
    private String BookName;
    //作者名
    private String authorName;
    private Integer borrowCount;
    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
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
