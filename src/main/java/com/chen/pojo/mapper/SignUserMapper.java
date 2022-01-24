package com.chen.pojo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.pojo.dao.SignUser;

public interface SignUserMapper extends BaseMapper<SignUser> {
    SignUser findByUserName(String userName);
}
