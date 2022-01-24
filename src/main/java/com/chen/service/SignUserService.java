package com.chen.service;

import com.chen.pojo.dao.SignUser;

public interface SignUserService {
    /**
     * 签到接口
     * @param userName
     * @return
     */
    SignUser signIn(String userName);
}
