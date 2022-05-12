package com.example.accenturespringbootdemo.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accenturespringbootdemo.entity.LoginLogEntity;
import com.example.accenturespringbootdemo.entity.UserEntity;
import com.example.accenturespringbootdemo.exception.BusinessFailureException;
import com.example.accenturespringbootdemo.repository.LoginLogRepository;
import com.example.accenturespringbootdemo.repository.UserRepository;
import com.example.accenturespringbootdemo.service.LoginService;

import javax.annotation.Resource;

/**
 * 登录业务实现层。
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private LoginLogRepository loginLogRepository;

    /**
     * 用户登录。
     * <p>根据用户名、密码登录系统</p>
     *
     * @param userName 用户名
     * @param password 密码
     * @return 用户信息
     */
    @Override
    public UserEntity login(String userName, String password) {
        // 根据用户名、密码查询用户信息。

        UserEntity user = userRepository.seletUserByNameAndPwd(userName, password);
        try{
        LocalDateTime now = LocalDateTime.now();
        if (user == null || now.isBefore(user.getValidStartTime()) || now.isAfter(user.getValidEndTime())) {
            // 用户不存在，或不在有效期内，则抛出业务异常。
            throw new RuntimeException("用户不存在，或不在有效期内");
        }

        LoginLogEntity loginLog = new LoginLogEntity();
        loginLog.setUserId(user.getUserId());
        loginLog.setUserType(user.getUserType());
        loginLog.setLoginDateTime(now);
        // 新建登录日志。
        loginLogRepository.insert(loginLog);

    }catch (Exception e){
    e.printStackTrace();
}
        return user;
    }
}
