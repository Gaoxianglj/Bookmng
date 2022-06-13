package com.example.accenturespringbootdemo.requestdto;

import javax.validation.constraints.NotNull;

public class BookIdForm {
    @NotNull(message = "id不能为空")
    String bookId;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
