package com.example.accenturespringbootdemo.service;
/**
 * 图书归还业务接口。
 */
public interface ReturnService {
    /**
     * 图书归还。
     * <p>归还图书并记录归还时间，更改图书信息表中数量</p>
     *
     * @param userId,bookId 用户Id，图书Id
     */
    public void BookReturn(Integer userId,Integer bookId);
}
