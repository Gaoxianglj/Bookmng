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
    @Override
    public List<BorrowHistoryForm> SelectBorrow(BorrowHistoryForm borrowHistoryForm) {
if(borrowHistoryForm.getBookName()==null){
System.out.println(borrowHistoryForm.isNoreturn()+"WWW"+borrowHistoryForm.getBorrowDate()+"service");}

        return borrowHistoryRepository.SelectBorrowHistoryList(borrowHistoryForm);
    }
}
