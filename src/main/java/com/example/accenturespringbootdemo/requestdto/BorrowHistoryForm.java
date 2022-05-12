package com.example.accenturespringbootdemo.requestdto;

import java.time.LocalDate;

public class BorrowHistoryForm {
    //用户ID
    private Integer userId;
    //图书ID
    private Integer bookId;
    //借阅日期
    private LocalDate borrowDate;
    //用户名
    private String userName;
    //图书名
    private String bookName;
    //出版社
    private String publisherName;
    //作者
    private String authorName;
    //是否归还
    private Integer noreturn;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer isNoreturn() {
        return noreturn;
    }

    public void setNoreturn(Integer noreturn) {
        this.noreturn = noreturn;
    }
}
