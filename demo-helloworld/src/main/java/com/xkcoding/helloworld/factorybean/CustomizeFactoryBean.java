package com.xkcoding.helloworld.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.xkcoding.helloworld.normalobject.Customize;

/**
 * @author huang.guangbing
 * @since 2024/9/13
 */
@Component
public class CustomizeFactoryBean implements FactoryBean<Customize>, InitializingBean {

    private Customize customize;

    @Override
    public Customize getObject() throws Exception {
        return customize;
    }

    @Override
    public Class<?> getObjectType() {
        return Customize.class;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (customize == null) {
            customize = Customize.builder()
                .id("1")
                .name("sun")
                .age(18)
                .address("beijing")
                .phone("123456789")
                .build();
        }
    }
}

