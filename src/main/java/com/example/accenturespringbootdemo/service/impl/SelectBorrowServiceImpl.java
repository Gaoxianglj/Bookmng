package com.example.accenturespringbootdemo.service.impl;

import com.example.accenturespringbootdemo.entity.BorrowHistoryEntity;
import com.example.accenturespringbootdemo.repository.BorrowHistoryRepository;
import com.example.accenturespringbootdemo.requestdto.BorrowHistoryForm;
import com.example.accenturespringbootdemo.service.SelectBorrowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class SelectBorrowServiceImpl implements SelectBorrowService {
    @Resource
    BorrowHistoryRepository borrowHistoryRepository;

    /**
     * 有条件查询借阅记录
     * @param borrowHistoryForm 查询条件
     * @return 符合要求的记录
     */
    @Override
    public List<BorrowHistoryForm> SelectBorrow(BorrowHistoryForm borrowHistoryForm) {
if(borrowHistoryForm.getBookName()==null){
System.out.println(borrowHistoryForm.isNoreturn()+"WWW"+borrowHistoryForm.getBorrowDate()+"service");}

        return borrowHistoryRepository.SelectBorrowHistoryList(borrowHistoryForm);
    }
}
