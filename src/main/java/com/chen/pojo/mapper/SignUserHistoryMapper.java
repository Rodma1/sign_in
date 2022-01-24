package com.chen.pojo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.pojo.dao.SignUserHistory;

import java.util.List;

public interface SignUserHistoryMapper extends BaseMapper<SignUserHistory> {
    List<SignUserHistory> findListByUserName(String userName);
}
