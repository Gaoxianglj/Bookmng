package com.example.accenturespringbootdemo.service.impl;

import com.example.accenturespringbootdemo.repository.BookRepository;
import com.example.accenturespringbootdemo.requestdto.BookSelectForm;
import com.example.accenturespringbootdemo.service.BookSelectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class BookSelectServiceImpl implements BookSelectService {
@Resource
    BookRepository bookRepository;
    /**
     * 有条件的查询图书列表
     * @param form 查询条件
     * @return 图书列表
     */
    @Override
    public BookSelectForm[] RetrieveByParams(BookSelectForm form) {

        return bookRepository.RetrieveByParams(form);
    }
}
