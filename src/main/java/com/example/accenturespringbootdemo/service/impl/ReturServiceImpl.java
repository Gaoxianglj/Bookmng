package com.example.accenturespringbootdemo.service.impl;

import com.example.accenturespringbootdemo.entity.BorrowHistoryEntity;
import com.example.accenturespringbootdemo.entity.UserBorrowHisorty;
import com.example.accenturespringbootdemo.exception.BusinessFailureException;
import com.example.accenturespringbootdemo.exception.MyException;
import com.example.accenturespringbootdemo.repository.BookRepository;
import com.example.accenturespringbootdemo.repository.BorrowHistoryRepository;
import com.example.accenturespringbootdemo.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 * 归还图书业务实现层。
 */
@Service
public class ReturServiceImpl implements ReturnService {
    @Resource
    BorrowHistoryRepository borrowHistoryRepository;
    @Resource
    BookRepository bookRepository;
    /**
     * 图书归还。
     * <p>归还图书并记录归还时间，更改图书信息表中数量</p>
     *
     * @param userId,bookId 用户Id，图书Id
     */
    @Override
    public void BookReturn(Integer userId, Integer bookId) {

        LocalDate returnDate=LocalDate.now();//获取系统当前日期

        LocalDateTime updateDateTime=LocalDateTime.now();//获取系统当前时间
        BorrowHistoryEntity borrowHistoryEntity=borrowHistoryRepository.SelectBorrowHistory(userId,bookId);
        if(borrowHistoryEntity.getReturnDate()!=null){
            //一条借阅履历不能归还两遍
            throw new RuntimeException("一条借阅履历不能归还两遍");
        }
        int borrowMessage=borrowHistoryRepository.ReturnBook(userId,bookId,returnDate,updateDateTime);
        if(borrowMessage<=0){
            //更新失败则抛出业务异常
            throw new RuntimeException("更新失败,请联系后台");
        }
        int bookMessage=bookRepository.UpdateQuantity(bookId,1,updateDateTime);
        if(bookMessage<=0){
            //更新失败则抛出业务异常
            throw new RuntimeException("图书数量更新失败，请联系后台");
        }


    }

    @Override
    public UserBorrowHisorty[] UserBorrowHistoryList(String userId) {
        System.out.println("用户Id"+userId
        );
        return borrowHistoryRepository.SelectUserBorrowHisortyList(Integer.valueOf(userId));
    }
}
