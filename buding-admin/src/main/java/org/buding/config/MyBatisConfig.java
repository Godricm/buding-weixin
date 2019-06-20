package org.buding.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@EnableTransactionManagement
@MapperScan({"org.buding.domain","org.buding.dao"})
public class MyBatisConfig {
}
