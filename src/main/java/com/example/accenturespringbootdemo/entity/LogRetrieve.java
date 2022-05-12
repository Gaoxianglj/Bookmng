package com.example.accenturespringbootdemo.entity;

import java.time.LocalDateTime;
/**
 * 登录日志实体类。
 */
public class LogRetrieve {
    //用户Id
    Integer userId;
    //用户名
    String userName;
    //用户类型
    Integer userType;
    //登录时间
    LocalDateTime loginDateTime;
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public LocalDateTime getLoginDateTime() {
        return loginDateTime;
    }

    public void setLoginDateTime(LocalDateTime loginDateTime) {
        this.loginDateTime = loginDateTime;
    }

}
