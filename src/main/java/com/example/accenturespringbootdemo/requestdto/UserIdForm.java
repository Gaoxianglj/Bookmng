package com.example.accenturespringbootdemo.requestdto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserIdForm {
    //用户Id
    @NotBlank(message = "用户Id不能为空")
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
