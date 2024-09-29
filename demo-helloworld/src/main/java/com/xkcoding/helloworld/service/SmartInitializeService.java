package com.xkcoding.helloworld.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huang.guangbing
 * @since 2024/9/13
 */
@Service
public class SmartInitializeService implements SmartInitializingSingleton, InitializingBean {

    @Autowired
    private CustomizeService customizeService;

    @Override
    public void afterSingletonsInstantiated() {
        System.out.println("SmartInitializingSingleton invoked " + customizeService);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet invoked " + customizeService);

    }
}
