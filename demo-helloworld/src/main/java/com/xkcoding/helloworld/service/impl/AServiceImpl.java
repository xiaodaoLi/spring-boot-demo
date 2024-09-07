package com.xkcoding.helloworld.service.impl;

import com.xkcoding.helloworld.service.AService;
import com.xkcoding.helloworld.service.CService;

/**
 * @author huang.guangbing
 * @since 2024/8/20
 */
//@Service
public class AServiceImpl implements AService {

    private CService cService;

    public AServiceImpl(CService cService) {
        this.cService = cService;
    }

    @Override
    public String helloAService(String name) {
        String s = "helloAService " + name;
        System.out.println(s);
        return s;
    }
}
