package com.xkcoding.helloworld;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.xkcoding.helloworld.normalobject.Customize;
import com.xkcoding.helloworld.factorybean.CustomizeFactoryBean;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoHelloworldApplicationTests {

    @Autowired
    private Customize customize;

    @Autowired
    private CustomizeFactoryBean customizeFactoryBean;

    @Test
    public void contextLoads() throws Exception {
        System.out.println(customizeFactoryBean);
        System.out.println(customizeFactoryBean.getObject());
        System.out.println(customize);
    }

}
