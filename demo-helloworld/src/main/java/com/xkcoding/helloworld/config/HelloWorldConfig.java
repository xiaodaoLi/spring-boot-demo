package com.xkcoding.helloworld.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.xkcoding.helloworld.service.AService;
import com.xkcoding.helloworld.service.BService;
import com.xkcoding.helloworld.service.CService;
import com.xkcoding.helloworld.service.impl.AServiceImpl;
import com.xkcoding.helloworld.service.impl.BServiceImpl;
import com.xkcoding.helloworld.service.impl.CServiceImpl;

/**
 * @author huang.guangbing
 * @since 2024/8/20
 */
@ComponentScan(basePackages = "com.xkcoding.helloworld")
// 加上@Configuration 注解之后cService只创建了一次， 没加则创建了3次
//@Configuration
public class HelloWorldConfig {

    @Bean
    public AService aService() {
        // 没加@Configuration之前， 方法内的this为普通对象
        // 加上@Configuration之后， 方法内的this为代理对象
        return new AServiceImpl(cService());
    }

    @Bean
    public BService bService() {
        // 没加@Configuration之前， 方法内的this为普通对象
        // 加上@Configuration之后， 方法内的this为代理对象
        return new BServiceImpl(cService());
    }

    @Bean
    public CService cService() {
        // 没加@Configuration之前， 方法内的this为普通对象
        // 加上@Configuration之后， 方法内的this为代理对象
        System.out.println("cService is create. " + System.currentTimeMillis());
        return new CServiceImpl();
    }
}
