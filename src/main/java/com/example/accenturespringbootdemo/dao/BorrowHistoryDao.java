package com.example.accenturespringbootdemo.dao;

import com.example.accenturespringbootdemo.entity.BorrowHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (BorrowHistory)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-19 20:12:47
 */
 @Mapper
public interface BorrowHistoryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param historyId 主键
     * @return 实例对象
     */
    BorrowHistory queryById(Integer historyId);

    /**
     * 查询指定行数据
     *
     * @param borrowHistory 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<BorrowHistory> queryAllByLimit(BorrowHistory borrowHistory, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param borrowHistory 查询条件
     * @return 总行数
     */
    long count(BorrowHistory borrowHistory);

    /**
     * 新增数据
     *
     * @param borrowHistory 实例对象
     * @return 影响行数
     */
    int insert(BorrowHistory borrowHistory);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BorrowHistory> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BorrowHistory> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BorrowHistory> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BorrowHistory> entities);

    /**
     * 修改数据
     *
     * @param borrowHistory 实例对象
     * @return 影响行数
     */
    int update(BorrowHistory borrowHistory);

    /**
     * 通过主键删除数据
     *
     * @param historyId 主键
     * @return 影响行数
     */
    int deleteById(Integer historyId);

}

