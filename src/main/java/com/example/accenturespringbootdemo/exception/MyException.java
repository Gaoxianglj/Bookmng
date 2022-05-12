package com.example.accenturespringbootdemo.exception;

import org.springframework.validation.Errors;

public class MyException extends RuntimeException{
    private final transient String message;
    private final transient boolean isFormInvalid;
    public MyException(String message){
        super();
        this.message=message;
        this.isFormInvalid=true;
    }
    public MyException(){
        super();
        message="";
        isFormInvalid=true;
    }
}
