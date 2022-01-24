package com.chen.controller;

import com.chen.pojo.dao.SignUser;
import com.chen.service.SignUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
