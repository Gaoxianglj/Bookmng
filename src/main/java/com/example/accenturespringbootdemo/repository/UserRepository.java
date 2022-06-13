package com.example.accenturespringbootdemo.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.accenturespringbootdemo.entity.UserEntity;

/**
 * 用户Mapper映射器。
 */
@Repository
public interface UserRepository {
    /**
     * 根据用户名密码查询用户。
     *
     * @param userName 用户名
     * @param password 密码
     * @return 用户信息
     */
    public UserEntity seletUserByNameAndPwd(@Param("userName")String userName, @Param("password")String password);
    /**
     * 插入用户信息。
     *
     * @param user 用户信息
     */
    public int Registration(@Param("user") UserEntity user);
    /**
     * 更新用户信息。
     *
     * @param user 用户信息
     */
    public int UserUpdate(@Param("user") UserEntity user);
    /**
     * 根据用户名查询用户。
     *
     * @param userName 用户名
     * @return 用户信息
     */
    public UserEntity seletUserByName(@Param("userName")String userName);

    /**
     * 根据Id查询用户类
     * @param userId 用户Id
     * @return 符合条件的用户类
     */
    public UserEntity SelectUserById(@Param("userId")String userId);
}
