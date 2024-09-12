package com.xkcoding.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xkcoding.helloworld.factorybean.CustomizeFactoryBean;
import com.xkcoding.helloworld.normalobject.Customize;

/**
 * @author huang.guangbing
 * @since 2024/9/13
 */
@Service
public class CustomizeService {
    @Autowired
    private CustomizeFactoryBean customizeFactoryBean;

    @Autowired
    private Customize customize;


    public void printFactoryBean() throws Exception {
        System.out.println("autowired" + customizeFactoryBean);
        System.out.println("autowired" + customizeFactoryBean.getObject());
        System.out.println("autowired" + customize);
        System.out.println("========================");
    }
}
