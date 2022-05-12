package com.example.accenturespringbootdemo.repository;

import com.example.accenturespringbootdemo.entity.BookEntity;
import com.example.accenturespringbootdemo.requestdto.BookSelectForm;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 图书Mapper映射器。
 */
@Repository
public interface BookRepository {
    /**
     * 修改图书信息表图书库存。
     *
     * @param bookId          用户Id
     * @param updateQuantity  更新数量
     * @param updateDateTime  更新时间
     */
    public int UpdateQuantity(Integer bookId, Integer updateQuantity, LocalDateTime updateDateTime);
    /**
     * 根据书名查询图书。
     *
     * @param bookName          用户Id
     * @return book             图书
     */
    public BookEntity SelectByBookName(@Param("bookName")String bookName);
    /**
     * 根据书名查询图书。
     *
     * @param book         用户Id
     * @return              图书list
     */
    public List<BookEntity> SelectBook(@Param("book")BookEntity book);
    /**
     * 根据书内容查询图书。
     *
     * @param form         用户Id
     * @return              图书list
     */
    public BookSelectForm[] RetrieveByParams(@Param("book")BookSelectForm form);
}
