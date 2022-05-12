package com.example.accenturespringbootdemo.requestdto;

import org.apache.ibatis.annotations.Param;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 登录入力参数。
 */
public class LoginForm {
    // 用户名
    @NotBlank(message = "用户名不能为空。")
    private String userName;
    // 密码
    @NotBlank(message = "密码不能为空。")
    @Pattern(regexp = "^(?![0-9]+$)(?!a-zA-Z]+$)[0-9A-Za-z]{"+8+","+20+"}$",message = "密码须包含数字+大写+小写且密码长度小于等于20大于等于8")
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
