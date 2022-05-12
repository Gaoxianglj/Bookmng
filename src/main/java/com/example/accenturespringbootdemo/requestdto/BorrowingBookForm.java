package com.example.accenturespringbootdemo.requestdto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
/**
 * 借阅入力参数。
 */
public class BorrowingBookForm {
    //用户名
    @NotBlank(message = "用户名不能为空。")
    @Pattern(regexp = "^[\\u4E00-\\u9FA5a-zA-Z0-9_]{2,20}$",message = "数字汉字或英文字符，长度2-20。")
    private String userName;

    //
    @NotBlank(message = "书名不能为空。")
    private String bookName;

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
}
