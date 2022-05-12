package com.example.accenturespringbootdemo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.io.Serializable;

/**
 * 借阅履历(BorrowHistoryEntity)实体类
 */
public class BorrowHistoryEntity implements Serializable {
    private static final long serialVersionUID = 832910651924498640L;
    //履历ID
    private Integer historyId;
    //用户ID
    private Integer userId;
    //图书ID
    private Integer bookId;
    //借阅日期
    private LocalDate borrowDate;
    //归还日期
    private LocalDate returnDate;
    //创建时间
    private LocalDateTime createDateTime;
    //更新时间
    private LocalDateTime updateDateTime;
    //删除flag
    private Integer deleteFlag;


    public Integer getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Integer historyId) {
        this.historyId = historyId;
    }

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

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

}

