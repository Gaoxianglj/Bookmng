package com.example.accenturespringbootdemo.service.impl;

import com.example.accenturespringbootdemo.entity.LoginLog;
import com.example.accenturespringbootdemo.dao.LoginLogDao;
import com.example.accenturespringbootdemo.service.LoginLogService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (LoginLog)表服务实现类
 *
 * @author makejava
 * @since 2022-03-19 20:12:48
 */
@Service("loginLogService")
public class LoginLogServiceImpl implements LoginLogService {
    @Resource
    private LoginLogDao loginLogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param logId 主键
     * @return 实例对象
     */
    @Override
    public LoginLog queryById(Integer logId) {
        return this.loginLogDao.queryById(logId);
    }

    /**
     * 分页查询
     *
     * @param loginLog 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<LoginLog> queryByPage(LoginLog loginLog, PageRequest pageRequest) {
        long total = this.loginLogDao.count(loginLog);
        return new PageImpl<>(this.loginLogDao.queryAllByLimit(loginLog, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param loginLog 实例对象
     * @return 实例对象
     */
    @Override
    public LoginLog insert(LoginLog loginLog) {
        this.loginLogDao.insert(loginLog);
        return loginLog;
    }

    /**
     * 修改数据
     *
     * @param loginLog 实例对象
     * @return 实例对象
     */
    @Override
    public LoginLog update(LoginLog loginLog) {
        this.loginLogDao.update(loginLog);
        return this.queryById(loginLog.getLogId());
    }

    /**
     * 通过主键删除数据
     *
     * @param logId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer logId) {
        return this.loginLogDao.deleteById(logId) > 0;
    }
}
