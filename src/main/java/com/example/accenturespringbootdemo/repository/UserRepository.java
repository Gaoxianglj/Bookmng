package com.example.accenturespringbootdemo.repository;

import com.example.accenturespringbootdemo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    public User selectUserByNameAndPwd(@Param("email")String email,@Param("password")String password);
}
