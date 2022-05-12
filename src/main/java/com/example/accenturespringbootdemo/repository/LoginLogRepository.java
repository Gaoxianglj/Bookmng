package com.example.accenturespringbootdemo.repository;

import com.example.accenturespringbootdemo.entity.LogRetrieve;
import org.springframework.stereotype.Repository;

import com.example.accenturespringbootdemo.entity.LoginLogEntity;

import java.util.List;

/**
 * 登录日志Mapper映射器。
 */
@Repository
public interface LoginLogRepository {

    /**
     * 新建登录日志。
     *
     * @param loginLog 登录日志信息
     */
    public void insert(LoginLogEntity loginLog);
    /**
     * 登录日志管理。
     * @return List<LogRetrieve> 登录日志list
     */
    public List<LogRetrieve> LogRetrieve();
}
