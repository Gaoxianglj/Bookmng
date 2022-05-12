package com.example.accenturespringbootdemo.repository;

import com.example.accenturespringbootdemo.entity.BorrowHistoryEntity;
import com.example.accenturespringbootdemo.entity.RankingRetrieve.bookRankingRetrieve;
import com.example.accenturespringbootdemo.entity.RankingRetrieve.userRankingRetrieve;
import com.example.accenturespringbootdemo.requestdto.BorrowHistoryForm;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
/**
 * 借阅记录表Mapper映射器。
 */
@Repository
public interface BorrowHistoryRepository {
    /**
     * 更新借阅履历表。
     *
     * @param userId         用户Id
     * @param bookId         图书Id
     * @param returnDate     归还日期
     * @param updateDateTime 更新日期
     */
    public int ReturnBook(@Param("userId")Integer userId, @Param("bookId")Integer bookId, @Param("returnDate")LocalDate returnDate, @Param("updateDateTime")LocalDateTime updateDateTime);
    /**
     * 查询借阅履历表（根据用户id图书id）。
     *
     * @param userId         用户Id
     * @param bookId         图书Id
     * @return BorrowHistoryEntity 借阅记录
     */
    public BorrowHistoryEntity SelectBorrowHistory(@Param("userId")Integer userId, @Param("bookId")Integer bookId);
    /**
     * 查询图书借阅排行榜
     * @return List<bookRankingRetrieve> 借阅记录(以图书为聚集)list
     */
    public List<bookRankingRetrieve>  BookRetrieve();
    /**
     * 查询用户借阅排行榜
     * @return List<userRankingRetrieve> 借阅记录(以用户为聚集)list
     */
    public List<userRankingRetrieve>  UserRetrieve();
    /**
     * 新增用户借阅
     *
     * @param borrowHistoryEntity 借阅表对象
     *
     */
    public int insert(@Param("borrow")BorrowHistoryEntity borrowHistoryEntity);
    /**
     * 删除用户借阅
     *
     * @param historyId 借阅记录Id
     *
     */
    public int deleteById(@Param("historyId")Integer historyId);
    /**
     * 查询用户借阅（list）
     *
     * @param borrowHistory form记录
     *
     */
    public List<BorrowHistoryForm> SelectBorrowHistoryList(@Param("borrow") BorrowHistoryForm borrowHistory);
}
