package com.example.accenturespringbootdemo.service;

import com.example.accenturespringbootdemo.entity.BorrowHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (BorrowHistory)表服务接口
 *
 * @author makejava
 * @since 2022-03-19 20:12:47
 */
public interface BorrowHistoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param historyId 主键
     * @return 实例对象
     */
    BorrowHistory queryById(Integer historyId);

    /**
     * 分页查询
     *
     * @param borrowHistory 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<BorrowHistory> queryByPage(BorrowHistory borrowHistory, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param borrowHistory 实例对象
     * @return 实例对象
     */
    BorrowHistory insert(BorrowHistory borrowHistory);

    /**
     * 修改数据
     *
     * @param borrowHistory 实例对象
     * @return 实例对象
     */
    BorrowHistory update(BorrowHistory borrowHistory);

    /**
     * 通过主键删除数据
     *
     * @param historyId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer historyId);

}
