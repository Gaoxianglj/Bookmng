package com.example.accenturespringbootdemo.controller;

import com.example.accenturespringbootdemo.entity.BorrowHistoryEntity;
import com.example.accenturespringbootdemo.requestdto.BorrowHistoryForm;
import com.example.accenturespringbootdemo.service.BorrowingBookService;
import com.example.accenturespringbootdemo.service.SelectBorrowService;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
@RestController
public class SelectBorrowController {
    @Resource
    SelectBorrowService selectBorrowService;

    /**
     * 借阅记录查询
     * @param borrowHistoryForm 用户Id，图书Id，借阅日期，用户名，图书名，出版社，作者，是否归还
     * @return 符合条件的借阅记录条目
     */
    @PostMapping("/borrowHistory")
    public List<BorrowHistoryForm> SelectBorrow(@RequestBody BorrowHistoryForm borrowHistoryForm){
        System.out.println(borrowHistoryForm.getBookId()+"进来了");
        return selectBorrowService.SelectBorrow(borrowHistoryForm);

    }
}
