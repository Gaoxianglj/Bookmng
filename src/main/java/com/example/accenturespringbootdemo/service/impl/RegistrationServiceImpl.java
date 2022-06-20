package com.example.accenturespringbootdemo.service.impl;

import com.example.accenturespringbootdemo.entity.UserEntity;
import com.example.accenturespringbootdemo.exception.BusinessFailureException;
import com.example.accenturespringbootdemo.repository.UserRepository;
import com.example.accenturespringbootdemo.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
/**
 * 注册业务实现层。
 */
@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Resource
    private UserRepository userRepository;
    /**
     * 用户注册。
     * <p>根据用户填写内容注册用户信息</p>
     *
     * @param user 用户信息
     */
    @Override
    public void Registration(UserEntity user) {
    //向user表中插入信息
    LocalDateTime now=LocalDateTime.now();//获取系统时间
    user.setValidStartTime(now);
    user.setUpdateDateTime(now);
    user.setCreateDateTime(now);
    user.setValidEndTime(now.plusYears(10L));//有效期十年
    user.setDeleteFlag(false);
    user.setUserType(2);//正常注册为用户
    int message=userRepository.Registration(user);
    System.out.println("注册信号"+message);
    if(message<=0){
        // 注册失败则抛出业务异常。
        throw new RuntimeException("注册失败,请联系后台");
    }
    }
}
