package com.example.accenturespringbootdemo.controller;

import com.example.accenturespringbootdemo.entity.LoginLog;
import com.example.accenturespringbootdemo.service.LoginLogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (LoginLog)表控制层
 *
 * @author makejava
 * @since 2022-03-19 20:12:47
 */
@RestController
@RequestMapping("loginLog")
public class LoginLogController {
    /**
     * 服务对象
     */
    @Resource
    private LoginLogService loginLogService;

    /**
     * 分页查询
     *
     * @param loginLog 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<LoginLog>> queryByPage(LoginLog loginLog, PageRequest pageRequest) {
        return ResponseEntity.ok(this.loginLogService.queryByPage(loginLog, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<LoginLog> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.loginLogService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param loginLog 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<LoginLog> add(LoginLog loginLog) {
        return ResponseEntity.ok(this.loginLogService.insert(loginLog));
    }

    /**
     * 编辑数据
     *
     * @param loginLog 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<LoginLog> edit(LoginLog loginLog) {
        return ResponseEntity.ok(this.loginLogService.update(loginLog));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.loginLogService.deleteById(id));
    }

}

