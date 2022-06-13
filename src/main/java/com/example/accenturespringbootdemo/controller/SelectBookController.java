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

    /**
     * 有条件查询图书
     * <p>根据输入条件查找符合其条件的图书条目并返回给前端</p>
     * @param form 图书Id，作者名，图书名，出版社名，库存
     * @return 符合条件的图书列表
     */
    @PostMapping("/book/retrieve-by-params")
    public BookSelectForm[] RetrieveByParams(@RequestBody BookSelectForm form){
        System.out.println(form.getBookId()+"bookID");
        System.out.println(bookSelectService.RetrieveByParams(form).length+"数量");
        return bookSelectService.RetrieveByParams(form);
    }

}
