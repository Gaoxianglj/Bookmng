package com.example.accenturespringbootdemo.service;

import com.example.accenturespringbootdemo.entity.LogRetrieve;

import java.util.List;
/**
 * 登录日志导出业务接口。
 */
public interface LogRetrieveService {
    /**
     * 登录日志导出。
     *
     * @return 登录日志list
     */
    List<LogRetrieve> LogRetrieve();
}
