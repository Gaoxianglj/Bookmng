package com.example.accenturespringbootdemo.service;

import com.example.accenturespringbootdemo.entity.UserEntity;

/**
 * 登录业务接口。
 */
public interface LoginService {

    /**
     * 用户登录。
     * <p>根据用户名、密码登录系统</p>
     *
     * @param userName 用户名
     * @param password 密码
     * @return 用户信息
     */
    public UserEntity login(String userName, String password);
}
