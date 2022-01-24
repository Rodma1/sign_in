package com.chen.service.impl;

import com.chen.pojo.dao.SignUser;
import com.chen.pojo.mapper.SignUserMapper;
import com.chen.service.SignUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUserServiceImpl implements SignUserService {
    @Autowired(required = false)
    private SignUserMapper signUserMapper;
    /**
     * 用户签到
     * @param userName
     * @return
     */
    @Override
    public SignUser signIn(String userName) {
//        根据userName查询用户今天是否签到过
        SignUser signUser=signUserMapper.findByUserName(userName);
        return signUser;
    }
}
