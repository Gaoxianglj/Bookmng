package com.example.accenturespringbootdemo.requestdto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
/**
 * 借阅入力参数。
 */
public class BorrowingBookForm {
    //用户名
    @NotBlank(message = "用户Id不能为空。")

    private String userId;

    //
    @NotBlank(message = "图书Id不能为空。")
    private String bookId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
