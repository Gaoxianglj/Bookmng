package com.example.accenturespringbootdemo.service;
/**
 * 借阅图书业务接口。
 */
public interface BorrowingBookService {
    /**
     * 借阅图书。
     * <p>根据用户名，图书名借阅图书</p>
     *
     * @param userName 用户名
     * @param bookId 密码
     */
    public void BorrowingBook(String userName,String bookId);
}
