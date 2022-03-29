package com.example.accenturespringbootdemo.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (BorrowHistory)实体类
 *
 * @author makejava
 * @since 2022-03-19 20:12:47
 */
public class BorrowHistory implements Serializable {
    private static final long serialVersionUID = -48159733685316193L;
    /**
     * 履历ID
     */
    private Integer historyId;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 图书ID
     */
    private Integer bookId;
    /**
     * 借阅时间
     */
    private Date borrowDate;
    /**
     * 归还日期
     */
    private Date returnDate;
    /**
     * 创建时间
     */
    private Date createDateTime;
    /**
     * 更新时间
     */
    private Date updateDateTime;
    /**
     * 删除flag
     */
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

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Date getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

}

