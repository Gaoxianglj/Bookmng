package com.example.accenturespringbootdemo.controller;

import com.example.accenturespringbootdemo.entity.BookEntity;
import com.example.accenturespringbootdemo.exception.BusinessFailureException;
import com.example.accenturespringbootdemo.requestdto.BookIdForm;
import com.example.accenturespringbootdemo.requestdto.BookSelectForm;
import com.example.accenturespringbootdemo.service.BookService;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
public class BookController {
    @Resource
    BookService bookService;

    /**
     * 添加图书
     * @param form 输入内容
     * @param errors valid报错捕获
     */
    @PostMapping("/book/add")
   public void AddBook(@RequestBody @Valid BookSelectForm form, Errors errors){
       if (errors.hasErrors()) {
           // 当form中存在验证错误，则抛出业务错误，将验证信息输出。
           throw new BusinessFailureException(errors);
       }
       System.out.println("Addform"+form.getBookName());
         bookService.addBook(form);
    }

    /**
     * 删除图书
     * @param form 输入内容
     * @param errors valid报错捕获
     */
    @PostMapping("/book/delete")
    public void DeleteBook(@RequestBody @Valid BookIdForm form,Errors errors){
        if (errors.hasErrors()) {
            // 当form中存在验证错误，则抛出业务错误，将验证信息输出。
            throw new BusinessFailureException(errors);
        }
        bookService.deleteBook(form.getBookId());
    }

    /**
     * 修改图书内容
     * @param form 输入内容
     * @param errors valid报错捕获
     */
    @PostMapping("/book/edit")
    public void edit(@RequestBody @Valid BookSelectForm form,Errors errors){
        if (errors.hasErrors()) {
            // 当form中存在验证错误，则抛出业务错误，将验证信息输出。
            throw new BusinessFailureException(errors);
        }
        bookService.editBook(form);
    }
}
