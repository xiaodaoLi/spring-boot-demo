package com.xkcoding.helloworld.normalobject;

import lombok.Builder;
import lombok.Data;

/**
 * @author huang.guangbing
 * @since 2024/9/13
 */
@Data
@Builder
public class Customize {

    private String id;

    private String name;

    private int age;

    private String address;

    private String phone;
}

