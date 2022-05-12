package com.example.accenturespringbootdemo.service;

import com.example.accenturespringbootdemo.entity.UserEntity;
/**
 * 用户信息编辑业务接口。
 */
public interface UserUpdateService {
    /**
     * 用户登录。
     * <p>根据用户名、密码登录系统</p>
     *
     * @param user 用户类
     */
    public void UserUpdate(UserEntity user);
}
