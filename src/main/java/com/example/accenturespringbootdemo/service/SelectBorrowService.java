package com.example.accenturespringbootdemo.service;

import com.example.accenturespringbootdemo.entity.BorrowHistoryEntity;
import com.example.accenturespringbootdemo.requestdto.BorrowHistoryForm;

import java.util.List;

/**
 * 查询借阅业务接口。
 */
public interface SelectBorrowService {
    public List<BorrowHistoryForm> SelectBorrow(BorrowHistoryForm borrowHistoryForm);

}
