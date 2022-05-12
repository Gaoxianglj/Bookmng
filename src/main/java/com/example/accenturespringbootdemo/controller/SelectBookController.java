package com.example.accenturespringbootdemo.controller;

import com.example.accenturespringbootdemo.entity.BookEntity;
import com.example.accenturespringbootdemo.requestdto.BookSelectForm;
import com.example.accenturespringbootdemo.service.BookSelectService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
public class SelectBookController {
    @Resource
    BookSelectService bookSelectService;
    @PostMapping("/book/retrieve-by-params")
    public BookSelectForm[] RetrieveByParams(@RequestBody BookSelectForm form){
        System.out.println("aaaa"+form.getBookName());
        return bookSelectService.RetrieveByParams(form);
    }

}
