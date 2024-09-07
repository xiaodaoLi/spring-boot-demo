package com.xkcoding.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xkcoding.helloworld.config.HelloWorldConfig;
import com.xkcoding.helloworld.service.AService;

/**
 * @author huang.guangbing
 * @since 2024/8/20
 */
public class AnotationConfigAppHelloWorld {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
        final AService aService = context.getBean(AService.class);
        aService.helloAService("hgb");
    }
}
