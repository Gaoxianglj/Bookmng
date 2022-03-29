package com.example.accenturespringbootdemo.entity;

public  class  CommonResult<T> {
    private int code;
    private String message;
    private T data;
    public CommonResult<T> of(int code, String message, T data){
        return new CommonResult<T>(code,message,data);
    }
    public CommonResult(int code,String message,T data){
        this.code=code;
        this.message=message;
        this.data= data;
    }
}
