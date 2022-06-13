package com.example.accenturespringbootdemo.service.impl;

import com.example.accenturespringbootdemo.entity.UserEntity;
import com.example.accenturespringbootdemo.exception.BusinessFailureException;
import com.example.accenturespringbootdemo.repository.UserRepository;
import com.example.accenturespringbootdemo.service.UserUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
/**
 * 用户信息编辑业务实现层。
 */
@Service
public class UserUpdateServiceImpl implements UserUpdateService {
    @Resource
    UserRepository userRepository;
    /**
     * 用户登录。
     * <p>根据用户名、密码登录系统</p>
     *
     * @param user 用户类
     */
    @Override
    public void UserUpdate(UserEntity user) {
        user.setUpdateDateTime(LocalDateTime.now());
        System.out.println("email"+user.getEmail());
    int message=userRepository.UserUpdate(user);
        if(message<=0){
            // 注册失败则抛出业务异常。
            throw new RuntimeException("注册失败,请联系后台");
        }
        if(message==1){
            System.out.println("修改成功");
        }

    }
}
