package com.example.accenturespringbootdemo.requestdto;

import com.example.accenturespringbootdemo.entity.UserEntity;
import com.example.accenturespringbootdemo.exception.BusinessFailureException;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
/**
 * 用户信息编辑入力参数。
 */
public class UserUpdateForm {
    //用户名
    @NotBlank(message = "用户名不能为空。")
    @Pattern(regexp = "^[\\u4E00-\\u9FA5a-zA-Z0-9_]{2,20}$",message = "数字汉字或英文字符，长度2-20。")
    private String userName;

    //密码
    @NotBlank(message = "密码不能为空。")
    @Pattern(regexp = "^(?![0-9]+$)(?!a-zA-Z]+$)[0-9A-Za-z]{"+8+","+20+"}$",message ="密码须包含数字+大写+小写且密码长度小于等于20大于等于8" )
    private String password;

    //确认密码
    @NotBlank(message = "确认密码不能为空。")
    @Pattern(regexp = "^(?![0-9]+$)(?!a-zA-Z]+$)[0-9A-Za-z]{"+8+","+20+"}$",message = "密码须包含数字+大写+小写且密码长度小于等于20大于等于8")
    private String confirmpassword;

    //邮箱
    @Email(message = "须为邮箱格式")
    private String email;

    //生日
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "应为之前的日期")
    private LocalDate birthday;

    //性别
    @Max(value = 1,message = "性别输入错误")
    @Min(value = 0,message = "性别输入错误")
    private Integer gender;

    //年级
    @Max(value = 4,message = "年级不能大于4")
    @Min(value = 1,message = "年级不能小于1")
    private Integer grade;

    //兴趣
    @Size(min = 0,max = 200,message = "字数不能超过200")
    private String interest;

    //自我介绍
    @Size(max = 500,message = "字数不能超过500")
    private String introduction;

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

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public UserEntity forUser(){
        UserEntity user=new UserEntity();
        if(this.password.equals(this.confirmpassword)){
            user.setUserName(this.userName);
            user.setPassword(this.password);
            user.setEmail(this.email);
            user.setBirthday(this.birthday);
            user.setGender(this.gender);
            user.setGrade(this.grade);
            user.setInterest(this.interest);
            user.setIntroduction(this.introduction);
        }else {
            throw new BusinessFailureException(false);

        }
        return user;
    }

}

