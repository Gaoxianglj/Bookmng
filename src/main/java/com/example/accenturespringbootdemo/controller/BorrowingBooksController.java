package com.example.accenturespringbootdemo.controller;

import com.example.accenturespringbootdemo.exception.BusinessFailureException;
import com.example.accenturespringbootdemo.requestdto.BorrowingBookForm;
import com.example.accenturespringbootdemo.service.BorrowingBookService;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
public class BorrowingBooksController {
    @Resource
    BorrowingBookService borrowingBookService;
    /**
     * 图书借阅。
     * <p>根据用户名和书名借阅图书</p>
     *
     * @param form 用户名，书名。
     * @param errors 参数校验错误信息
     */
    @PostMapping("/book/borrow")
    public void BorrwoingBook(@RequestBody @Valid BorrowingBookForm form, Errors errors){
        if (errors.hasErrors()) {
            // 当form中存在验证错误，则抛出业务错误，将验证信息输出。
            throw new BusinessFailureException(errors);
        }
      borrowingBookService.BorrowingBook(form.getUserName(),form.getBookName());

    }
}
