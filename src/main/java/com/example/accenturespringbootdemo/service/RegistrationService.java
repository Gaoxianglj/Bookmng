package com.example.accenturespringbootdemo.service;

import com.example.accenturespringbootdemo.entity.UserEntity;

/**
 * 注册业务接口。
 */
public interface RegistrationService {
    /**
     * 用户注册。
     * <p>根据用户填写内容注册用户信息</p>
     *
     * @param user 用户信息
     */
    public void Registration( UserEntity user);
}
