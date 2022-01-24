package com.chen.service;

import com.chen.pojo.dao.SignUser;
import com.chen.pojo.dao.SignUserHistory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SignUserService {
    /**
     * 签到接口
     * @param userName
     * @return
     */
    @Transactional
    SignUser signIn(String userName);

    /**
     * 获取用户历史签到信息
     */
    List<SignUserHistory> listSignInHistory(String userName);

}
