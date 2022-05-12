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
    @Override
    public BookSelectForm[] RetrieveByParams(BookSelectForm form) {

        return bookRepository.RetrieveByParams(form);
    }
}
