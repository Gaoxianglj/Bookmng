package com.example.accenturespringbootdemo.service.impl;

import com.example.accenturespringbootdemo.entity.LogRetrieve;
import com.example.accenturespringbootdemo.repository.LoginLogRepository;
import com.example.accenturespringbootdemo.service.LogRetrieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * 登录日志导出业务实现层。
 */
@Service
public class LogRetrieveServiceImpl implements LogRetrieveService {
    @Resource
    LoginLogRepository loginLogRepository;
    /**
     * 登录日志导出。
     *
     * @return 登录日志list
     */
    @Override
    public List<LogRetrieve> LogRetrieve() {

        return loginLogRepository.LogRetrieve();
    }
}
