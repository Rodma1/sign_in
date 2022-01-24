package com.chen.config;
//配置类
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//扫包，将此包下的接口生成代理实现类，并且注册到spring容器中
@MapperScan("com.chen.pojo.mapper")
public class MybatisPlusConfig {
}