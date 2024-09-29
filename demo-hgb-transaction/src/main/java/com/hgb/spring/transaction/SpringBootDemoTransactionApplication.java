package com.hgb.spring.transaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author huang.guangbing
 * @since 2024/9/8
 */
@SpringBootApplication
@MapperScan("com.hgb.spring.transaction.mapper")
public class SpringBootDemoTransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoTransactionApplication.class, args);
    }
}
