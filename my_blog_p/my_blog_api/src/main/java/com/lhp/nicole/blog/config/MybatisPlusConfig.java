package com.lhp.nicole.blog.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.lhp.nicole.blog.mapper")
public class MybatisPlusConfig {
}
