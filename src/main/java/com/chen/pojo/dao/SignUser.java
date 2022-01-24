package com.chen.pojo.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 签到表
 */
@Data
public class SignUser {
   private Long id;
   private String encode;
//   用户名
   private String userName;
//   签到时间
// 指定为北京时间,将时间加八个小时pattern = "yyyy-MM-dd"
// :https://blog.csdn.net/ABestRookie/article/details/116637703
   @JsonFormat(timezone="GMT+8")
   private Date signInDate;
//   获取金币
   private Integer rewardMoney;
//   持续签到时间
   private Long continueSign;
   private Integer continueDay;
   private Date createTime;
   private Date updateTime;
   private Integer param1;

   private Integer param2;

   private Integer param3;

   private String param4;

   private String param5;

   private String param6;
   private String param7;
   private String param8;
   private String param9;

}
