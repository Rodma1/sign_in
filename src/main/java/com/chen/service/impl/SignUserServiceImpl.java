package com.chen.service.impl;

import com.chen.pojo.dao.SignUser;
import com.chen.pojo.dao.SignUserHistory;
import com.chen.pojo.mapper.SignUserHistoryMapper;
import com.chen.pojo.mapper.SignUserMapper;
import com.chen.service.SignUserService;
import com.chen.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class SignUserServiceImpl implements SignUserService {
    @Autowired(required = false)
    private SignUserMapper signUserMapper;
    @Autowired(required = false)
    private SignUserHistoryMapper signUserHistoryMapper;
    /**
     * 用户签到
     * @param userName
     * @return
     */
    @Override
    public SignUser signIn(String userName) {
//        根据userName查询用户今天是否签到过
        SignUser signUser=signUserMapper.findByUserName(userName);
        SignUserHistory signUserHistory=new SignUserHistory();
        //        如果记录是空的，说明以前没有签到过
        if(signUser==null){
            SignUser signUser1=new SignUser();
            signUser1.setUserName(userName);
//            设置连续签到天数1
            signUser1.setContinueSign((long)1);
//            金币数加一
            signUser1.setRewardMoney(1);
//            设置时间
            signUser1.setSignInDate(DateUtils.getTodayDate());
            //            插入到数据库中
            signUserMapper.insert(signUser1);
            BeanUtils.copyProperties(signUser1,signUserHistory);
            signUserHistoryMapper.insert(signUserHistory);
            return signUser1;
        }
//        获取登录的时间
        long signInDateTime=signUser.getSignInDate().getTime();
//        如果和今天的时间一样说明已经签到过了
        if (signInDateTime==DateUtils.getTodayDate().getTime()){
            log.info("今天已经签到过了");
            return null;
        }
//      更新签到表对应用户的天数，和金币数
        signUser.setSignInDate(DateUtils.getTodayDate());
        signUser.setRewardMoney(signUser.getRewardMoney()+1);
//        设置连续天数
        signUser.setContinueSign(continueSign(signUser.getContinueSign(),signInDateTime));
//        设置更新时间
        signUser.setUpdateTime(new Date());

        BeanUtils.copyProperties(signUser,signUserHistory);
        signUserHistoryMapper.insert(signUserHistory);
        signUserMapper.updateById(signUser);
        log.info("签到更新成功");
        return signUser;
    }

    /**
     * 获取用户历史签到信息
     * @param userName
     * @return
     */
    @Override
    public List<SignUserHistory> listSignInHistory(String userName) {
        return signUserHistoryMapper.findListByUserName(userName);
    }

    //    查看是昨天是否签到了
    private Long continueSign(Long continueSign, Long signInDateTime){
        //        设置天数,如果签到时间小于昨天，说明就是以前签到的了，
        //        从新开始，如果等于昨天那么今天也算是连续签到

        if (signInDateTime<DateUtils.getYesterdayDate().getTime()){
           return (long)1;
        }
        return continueSign+1;

    }
}
