package com.example.accenturespringbootdemo.service.impl;

import com.example.accenturespringbootdemo.entity.BorrowHistory;
import com.example.accenturespringbootdemo.dao.BorrowHistoryDao;
import com.example.accenturespringbootdemo.service.BorrowHistoryService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (BorrowHistory)表服务实现类
 *
 * @author makejava
 * @since 2022-03-19 20:12:47
 */
@Service("borrowHistoryService")
public class BorrowHistoryServiceImpl implements BorrowHistoryService {
    @Resource
    private BorrowHistoryDao borrowHistoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param historyId 主键
     * @return 实例对象
     */
    @Override
    public BorrowHistory queryById(Integer historyId) {
        return this.borrowHistoryDao.queryById(historyId);
    }

    /**
     * 分页查询
     *
     * @param borrowHistory 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<BorrowHistory> queryByPage(BorrowHistory borrowHistory, PageRequest pageRequest) {
        long total = this.borrowHistoryDao.count(borrowHistory);
        return new PageImpl<>(this.borrowHistoryDao.queryAllByLimit(borrowHistory, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param borrowHistory 实例对象
     * @return 实例对象
     */
    @Override
    public BorrowHistory insert(BorrowHistory borrowHistory) {
        this.borrowHistoryDao.insert(borrowHistory);
        return borrowHistory;
    }

    /**
     * 修改数据
     *
     * @param borrowHistory 实例对象
     * @return 实例对象
     */
    @Override
    public BorrowHistory update(BorrowHistory borrowHistory) {
        this.borrowHistoryDao.update(borrowHistory);
        return this.queryById(borrowHistory.getHistoryId());
    }

    /**
     * 通过主键删除数据
     *
     * @param historyId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer historyId) {
        return this.borrowHistoryDao.deleteById(historyId) > 0;
    }
}
