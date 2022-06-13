package com.example.accenturespringbootdemo.controller;

import com.example.accenturespringbootdemo.exception.BusinessFailureException;
import com.example.accenturespringbootdemo.requestdto.UserUpdateForm;
import com.example.accenturespringbootdemo.service.UserUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
public class UserUpdateController {
    @Resource
    UserUpdateService userUpdateService;
    /**
     * 用户信息编辑。
     * <p>根据用户名（不可变）更改用户信息</p>
     *
     * @param form 用户名，密码，确认密码，电子邮件，生日，性别，年级，兴趣，自我介绍。
     * @param errors 参数校验错误信息
     */
    @PostMapping("/user/update")
    public void UserUpdate(@RequestBody @Valid UserUpdateForm form, Errors errors){

        if (errors.hasErrors()) {
            // 当form中存在验证错误，则抛出业务错误，将验证信息输出。
            throw new BusinessFailureException(errors);
        }
        System.out.println("开始修改用户信息");
        userUpdateService.UserUpdate(form.forUser());

    }
}
