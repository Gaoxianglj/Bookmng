package com.example.accenturespringbootdemo.controller;

import com.example.accenturespringbootdemo.exception.BusinessFailureException;
import com.example.accenturespringbootdemo.requestdto.Returnform;
import com.example.accenturespringbootdemo.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
public class ReturnController {
    @Resource
    ReturnService returnService;
    /**
     * 图书归还。
     * <p>归还图书并记录归还时间，更改图书信息表中数量</p>
     *
     * @param form 用户Id，图书Id。
     * @param errors 参数校验错误信息
     */
    @PostMapping("book/return")
    public void BookReturn(@RequestBody @Valid Returnform form, Errors errors){
        if (errors.hasErrors()) {
            // 当form中存在验证错误，则抛出业务错误，将验证信息输出。
            throw new BusinessFailureException(errors);
        }
       returnService.BookReturn(form.getUserId(),form.getBookId());
    }
}
