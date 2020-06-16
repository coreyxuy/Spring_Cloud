package com.toloan.pay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableFeignClients(basePackages = "com.toloan.pay.client")
@EnableTransactionManagement//开启事务再service需要的方法添加@Transactional注解
@SpringCloudApplication
@ComponentScan(basePackages = "com.toloan")
@MapperScan("com.toloan.pay.mapper")
@EnableScheduling // 定时任务
public class DiversionApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiversionApplication.class, args);
    }
}

