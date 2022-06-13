package com.example.accenturespringbootdemo.service.impl;

import com.example.accenturespringbootdemo.entity.BookEntity;
import com.example.accenturespringbootdemo.entity.BorrowHistoryEntity;
import com.example.accenturespringbootdemo.entity.UserEntity;
import com.example.accenturespringbootdemo.exception.BusinessFailureException;
import com.example.accenturespringbootdemo.exception.MyException;
import com.example.accenturespringbootdemo.repository.BookRepository;
import com.example.accenturespringbootdemo.repository.BorrowHistoryRepository;
import com.example.accenturespringbootdemo.repository.UserRepository;
import com.example.accenturespringbootdemo.service.BorrowingBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 * 图书借阅业务实现层。
 */
@Service
public class BorrowingBookServiceImpl implements BorrowingBookService {
    @Resource
    UserRepository userRepository;
    @Resource
    BookRepository bookRepository;
    @Resource
    BorrowHistoryRepository borrowHistoryRepository;
    /**
     * 借阅图书。
     * <p>根据用户名，图书名借阅图书</p>
     *
     * @param userId 用户名
     * @param bookId 密码
     */
    @Override
    public void BorrowingBook(String userId, String bookId) {
        System.out.println("进入service");
        //检查用户是否存在
        UserEntity user=userRepository.SelectUserById(userId);
        System.out.println("借阅用户Id"+user.getUserId());
        if(user.getUserId()==null || user.getDeleteFlag()){
            System.out.println("用户不存在或已过期");
            throw new RuntimeException("用户不存在或已过期");
        }
        //检查书籍是否存在
        BookEntity book=bookRepository.SelectBookById(bookId);
        if(book.getBookId()==null ||book.getDeleteFlag()){
            throw new RuntimeException("书籍不存在或已过期");
        }
        if(book.getQuantity()<1){
            throw new RuntimeException("图书库存为空，无法外借");
        }
        //添加借阅对象内容
        BorrowHistoryEntity borrowHistoryEntity=new BorrowHistoryEntity();
        borrowHistoryEntity.setBookId(book.getBookId());
        borrowHistoryEntity.setUserId(user.getUserId());
        borrowHistoryEntity.setBorrowDate(LocalDate.now());
        borrowHistoryEntity.setCreateDateTime(LocalDateTime.now());
        borrowHistoryEntity.setUpdateDateTime(LocalDateTime.now());
        //检查是否有同种书未归还
        System.out.println("检查是否有同种书未归还"+borrowHistoryEntity.getBookId()+"图书Id"+borrowHistoryEntity.getUserId()+"用户Id");
        BorrowHistoryEntity borrowHistory=borrowHistoryRepository.SelectBorrowHistory(borrowHistoryEntity.getUserId(),borrowHistoryEntity.getBookId());
        System.out.println("检查是否有同种书未归还end"+borrowHistory);
        if(borrowHistory!=null&&borrowHistory.getReturnDate()==null){
            throw new RuntimeException("你所借的图书你已经借过相同的且还没有归还，请先归还上一本再来借阅");
        }
        //添加借阅表
        System.out.println("添加借阅表");
        int message=borrowHistoryRepository.insert(borrowHistoryEntity);
        if(message<=0){
            throw new RuntimeException("录入失败，请与后台维护人员联系");
        }

        //减少图书库存
        System.out.println("减少图书库存");
        int message1=bookRepository.UpdateQuantity(borrowHistoryEntity.getBookId(),-1,LocalDateTime.now());
        if(message1<=0){
            //因减少库存失败所以删除借阅记录
            int messageByDelete=borrowHistoryRepository.deleteById(borrowHistoryEntity.getHistoryId());
            if(messageByDelete<=0){
                throw new RuntimeException("因库存减少失败试图删除借阅记录失败，严重后台错误！！！");
            }
            throw new RuntimeException("库存减少失败，请与后台维护人员联系");
        }
    }
}
