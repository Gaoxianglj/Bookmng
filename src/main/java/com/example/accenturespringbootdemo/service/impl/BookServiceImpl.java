package com.example.accenturespringbootdemo.service.impl;

import com.example.accenturespringbootdemo.entity.BookEntity;
import com.example.accenturespringbootdemo.repository.BookRepository;
import com.example.accenturespringbootdemo.requestdto.BookSelectForm;
import com.example.accenturespringbootdemo.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    BookRepository bookRepository;
    /**
     * 添加图书
     * @param form 输入内容
     */
    @Override
    public void addBook(BookSelectForm form) {
        BookEntity book=new BookEntity();
        book.setBookName(form.getBookName());book.setAuthorName(form.getAuthorName());book.setPublisherName(form.getPublisherName());book.setQuantity(form.getQuantity());
        book.setCreateDateTime(LocalDateTime.now());book.setUpdateDateTime(LocalDateTime.now());book.setDeleteFlag(false);
        System.out.println("BookName"+book.getBookName());
        int i=bookRepository.insertBook(book);
        System.out.println("添加"+i);
        if(i<=0){
            System.out.println("添加失败");
            throw new RuntimeException("添加失败");

        }
    }
    /**
     * 删除图书
     * @param bookId 图书Id
     */
    @Override
    public void deleteBook(String bookId) {
        int i=bookRepository.deleteBook(Integer.valueOf(bookId));
        if(i<=0){
            throw new RuntimeException("删除失败");
        }
    }
    /**
     * 修改图书内容
     * @param form 输入内容
     */
    @Override
    public void editBook(BookSelectForm form) {
        System.out.println("update:"+form.getBookName());
        int i=bookRepository.updateBook(form);
        if(i<=0){
            throw new RuntimeException("修改失败");
        }
    }
}
