package com.example.accenturespringbootdemo.controller;

import com.example.accenturespringbootdemo.entity.LogRetrieve;
import com.example.accenturespringbootdemo.service.LogRetrieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class LogRetrieveController {
    @Resource
    LogRetrieveService logRetrieveService;
    /**
     * 登录日志。
     * <p>显示登录日志</p>
     *
     * @return 登录日志。
     */
    @PostMapping("/login/retrieve")
    public List<LogRetrieve> LogRetrieve(){
        return logRetrieveService.LogRetrieve();
    }
}
