package com.example.accenturespringbootdemo.entity;

import java.time.LocalDate;

public class UserBorrowHisorty {
    //图书Id
    private String bookId;
    //书名
    private String bookName;
    //借阅日期
    private LocalDate BorrowDate;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public LocalDate getBorrowDate() {
        return BorrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        BorrowDate = borrowDate;
    }
}
