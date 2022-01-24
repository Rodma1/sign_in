package com.chen.controller;

import com.chen.pojo.dao.SignUser;
import com.chen.pojo.dao.SignUserHistory;
import com.chen.service.SignUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sign")
public class SignUserController {
    @Autowired
    private SignUserService signUserService;
    /**
     * 用户进行签到
     */
    @PostMapping
     public SignUser userSignIn(String userName){
        return signUserService.signIn(userName);

     }
    /**
     * 查询用户签到历史消息
     */
    @GetMapping("/listsign")
    public List<SignUserHistory> selectSignInHistory(@Validated String userName){
        return signUserService.listSignInHistory(userName);
    }
}
