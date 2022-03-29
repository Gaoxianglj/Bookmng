package com.example.accenturespringbootdemo.controller;

import com.example.accenturespringbootdemo.entity.BorrowHistory;
import com.example.accenturespringbootdemo.service.BorrowHistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (BorrowHistory)表控制层
 *
 * @author makejava
 * @since 2022-03-19 20:12:47
 */
@RestController
@RequestMapping("borrowHistory")
public class BorrowHistoryController {
    /**
     * 服务对象
     */
    @Resource
    private BorrowHistoryService borrowHistoryService;

    /**
     * 分页查询
     *
     * @param borrowHistory 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<BorrowHistory>> queryByPage(BorrowHistory borrowHistory, PageRequest pageRequest) {
        return ResponseEntity.ok(this.borrowHistoryService.queryByPage(borrowHistory, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<BorrowHistory> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.borrowHistoryService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param borrowHistory 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<BorrowHistory> add(BorrowHistory borrowHistory) {
        return ResponseEntity.ok(this.borrowHistoryService.insert(borrowHistory));
    }

    /**
     * 编辑数据
     *
     * @param borrowHistory 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<BorrowHistory> edit(BorrowHistory borrowHistory) {
        return ResponseEntity.ok(this.borrowHistoryService.update(borrowHistory));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.borrowHistoryService.deleteById(id));
    }

}

