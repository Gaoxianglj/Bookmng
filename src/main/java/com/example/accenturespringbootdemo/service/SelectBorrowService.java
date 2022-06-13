package com.example.accenturespringbootdemo.service;

import com.example.accenturespringbootdemo.entity.BorrowHistoryEntity;
import com.example.accenturespringbootdemo.requestdto.BorrowHistoryForm;

import java.util.List;

/**
 * 查询借阅业务接口。
 */
public interface SelectBorrowService {
    /**
     * 有条件查询借阅记录
     * @param borrowHistoryForm 查询条件
     * @return 符合要求的记录
     */
    public List<BorrowHistoryForm> SelectBorrow(BorrowHistoryForm borrowHistoryForm);

}
