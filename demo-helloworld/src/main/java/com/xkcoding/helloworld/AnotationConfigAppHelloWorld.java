package com.xkcoding.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xkcoding.helloworld.config.HelloWorldConfig;
import com.xkcoding.helloworld.normalobject.Customize;
import com.xkcoding.helloworld.service.AService;
import com.xkcoding.helloworld.service.CustomizeService;

/**
 * @author huang.guangbing
 * @since 2024/8/20
 */
public class AnotationConfigAppHelloWorld {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
        final AService aService = context.getBean(AService.class);
        aService.helloAService("hgb");

        final CustomizeService customizeService = context.getBean(CustomizeService.class);
        customizeService.printFactoryBean();


        // 通过名称获取bean实际上获取到的是 FactoryBean.getObject() 返回的对象
        final Object customizeFactoryBean = context.getBean("customizeFactoryBean");
        System.out.println("customizeFactoryBean " + customizeFactoryBean);

        System.out.println("-------------------------------");
        //如果想获取到FactoryBean本身，需要加 & 前缀
        final Object $customizeFactoryBean = context.getBean("&customizeFactoryBean");
        System.out.println("&customizeFactoryBean " + $customizeFactoryBean);

        System.out.println("----------------------------------");
        //final Object customize = context.getBean("customize");
        final Object customize = context.getBean(Customize.class);
        System.out.println("customize " + customize);
    }
}
