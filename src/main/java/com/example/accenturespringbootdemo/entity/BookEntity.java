package com.example.accenturespringbootdemo.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 图书信息表(BookEntity)实体类
 */
public class BookEntity implements Serializable {
    private static final long serialVersionUID = 380663573985901181L;
    //图书ID
    private Integer bookId;
    //作者
    private String authorName;
    //出版社
    private String publisherName;
    //书名
    private String bookName;
    //库存
    private Integer quantity;
    //创建时间
    private Date createDateTime;
    //更新时间
    private Date updateDateTime;
    //删除flag
    private boolean deleteFlag;


    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

}

