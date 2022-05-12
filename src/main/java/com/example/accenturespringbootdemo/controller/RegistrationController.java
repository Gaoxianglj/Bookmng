package com.example.accenturespringbootdemo.controller;

import com.example.accenturespringbootdemo.exception.BusinessFailureException;
import com.example.accenturespringbootdemo.requestdto.RegistrationFrom;
import com.example.accenturespringbootdemo.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RegistrationController {
    @Autowired
    RegistrationService registrationService;
    /**
     * 用户注册。
     * <p>根据用户填写内容注册用户信息</p>
     *
     * @param form 用户名，密码,确认密码，电子邮件，生日，性别，年级，兴趣，自我介绍。
     * @param errors 参数校验错误信息
     */
    @PostMapping("user/registration")
    public void registration(@RequestBody @Valid RegistrationFrom form, Errors errors){
        if (errors.hasErrors()) {
            // 当form中存在验证错误，则抛出业务错误，将验证信息输出。
            throw new BusinessFailureException(errors);
        }

        registrationService.Registration(form.forUser());
    }
}
