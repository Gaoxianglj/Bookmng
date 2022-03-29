package com.example.accenturespringbootdemo.requestdto;

import javax.validation.constraints.NotBlank;

public class LgoinForm {
    @NotBlank(message = "用户名不能为空")
    //用户名
    private String userName;
    @NotBlank(message = "密码不能为空")
    //密码
    private String password;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
