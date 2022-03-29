package com.example.accenturespringbootdemo.dao;

import com.example.accenturespringbootdemo.entity.LoginLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (LoginLog)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-19 20:12:47
 */
 @Mapper
public interface LoginLogDao {

    /**
     * 通过ID查询单条数据
     *
     * @param logId 主键
     * @return 实例对象
     */
    LoginLog queryById(Integer logId);

    /**
     * 查询指定行数据
     *
     * @param loginLog 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<LoginLog> queryAllByLimit(LoginLog loginLog, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param loginLog 查询条件
     * @return 总行数
     */
    long count(LoginLog loginLog);

    /**
     * 新增数据
     *
     * @param loginLog 实例对象
     * @return 影响行数
     */
    int insert(LoginLog loginLog);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<LoginLog> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<LoginLog> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<LoginLog> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<LoginLog> entities);

    /**
     * 修改数据
     *
     * @param loginLog 实例对象
     * @return 影响行数
     */
    int update(LoginLog loginLog);

    /**
     * 通过主键删除数据
     *
     * @param logId 主键
     * @return 影响行数
     */
    int deleteById(Integer logId);

}

