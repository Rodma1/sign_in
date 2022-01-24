package com.chen.enums;

/**
 * 签到枚举信息
 */
public enum SignInEnum {
        CONTINUITEDAYZERO(0,"连续签到初始值"),
        CONTINUITEDAYONE(1,"连续签到第一天"),
        UNSGIN(0,"今日未签到"),
        SIGNED(1,"今日已签到"),
        MONEY(1,"金币");
        public final Integer type;
        public final String content;
        SignInEnum(Integer type,String content){
            this.type = type;
            this.content = content;
        }
        public Integer getType(){
            return type;
        }
        public String getContent(){
            return content;
        }
}
