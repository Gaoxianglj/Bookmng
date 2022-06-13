package com.example.accenturespringbootdemo.service;

import com.example.accenturespringbootdemo.requestdto.BookSelectForm;

public interface BookService {
    /**
     * 添加图书
     * @param form 输入内容
     */
    public void addBook(BookSelectForm form);
    /**
     * 删除图书
     * @param bookId 图书Id
     */
    public void deleteBook(String bookId);

    /**
     * 修改图书内容
     * @param form 输入内容
     */
    public void editBook(BookSelectForm form);
}
