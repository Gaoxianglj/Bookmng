package com.example.accenturespringbootdemo.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (LoginLog)实体类
 *
 * @author makejava
 * @since 2022-03-19 20:12:47
 */
public class LoginLog implements Serializable {
    private static final long serialVersionUID = 329709949961486479L;
    /**
     * 日志ID
     */
    private Integer logId;
    /**
     * 用户ID（FK）
     */
    private Integer userId;
    /**
     * 用户级别
     */
    private Integer userType;
    /**
     * 登录日期
     */
    private Date loginDateTime;
    /**
     * 更新日期
     */
    private Date updateDateTime;
    /**
     * 删除flag
     */
    private Integer deleteFlag;


    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Date getLoginDateTime() {
        return loginDateTime;
    }

    public void setLoginDateTime(Date loginDateTime) {
        this.loginDateTime = loginDateTime;
    }

    public Date getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

}

