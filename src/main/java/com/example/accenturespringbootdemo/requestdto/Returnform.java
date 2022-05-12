package com.example.accenturespringbootdemo.requestdto;


import javax.validation.constraints.NotNull;
/**
 * 归还入力参数。
 */
public class Returnform {
    //用户id
    @NotNull(message = "用户id不能为空")
    Integer userId;

    //图书id
    @NotNull(message = "图书id不能为空")
    Integer bookId;
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


}
