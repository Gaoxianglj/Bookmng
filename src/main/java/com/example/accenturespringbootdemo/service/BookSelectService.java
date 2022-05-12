package com.example.accenturespringbootdemo.service;

import com.example.accenturespringbootdemo.requestdto.BookSelectForm;

import java.util.List;

public interface BookSelectService {
    BookSelectForm[] RetrieveByParams(BookSelectForm form);
}
