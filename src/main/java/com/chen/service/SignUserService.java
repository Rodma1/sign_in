package com.chen.service;

import com.chen.pojo.dao.SignUser;
import org.springframework.transaction.annotation.Transactional;

public interface SignUserService {
    /**
     * 签到接口
     * @param userName
     * @return
     */
    @Transactional
    SignUser signIn(String userName);
}
