package com.example.accenturespringbootdemo.service;

import com.example.accenturespringbootdemo.requestdto.BookSelectForm;

import java.util.List;

public interface BookSelectService {
    /**
     * 有条件的查询图书列表
     * @param form 查询条件
     * @return 图书列表
     */
    BookSelectForm[] RetrieveByParams(BookSelectForm form);
}
