package com.xkcoding.helloworld.service.impl;

import com.xkcoding.helloworld.service.BService;
import com.xkcoding.helloworld.service.CService;

/**
 * @author huang.guangbing
 * @since 2024/8/20
 */
//@Service
public class BServiceImpl implements BService {

    private CService cService;

    public BServiceImpl(CService cService) {
        this.cService = cService;
    }
}
