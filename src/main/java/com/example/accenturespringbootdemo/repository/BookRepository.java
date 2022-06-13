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

    /**
     * 添加图书
     * @param book 图书类
     * @return 确认是否添加成功
     */
    public int insertBook(@Param("book")BookEntity book);

    /**
     * 根据bookId删除图书
     * @param bookId 图书Id
     * @return 确认是否删除成功
     */
    public int deleteBook(@Param("bookId")Integer bookId);

    /**
     * 更新图书内容
     * @param form 更新图书内容
     * @return 确认是否更新成功
     */
    public int updateBook(@Param("book")BookSelectForm form);

    /**
     * 根据图书Id查询图书类
     * @param bookId 图书Id
     * @return 符合的图书类
     */
    public BookEntity SelectBookById(@Param("bookId") String bookId);
}
