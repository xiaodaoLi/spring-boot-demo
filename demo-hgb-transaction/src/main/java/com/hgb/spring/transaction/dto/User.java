package com.hgb.spring.transaction.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huang.guangbing
 * @since 2024/9/8
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    Long userId;

    String userName;

    Long userAge;

    String userSex;

    List<UserAttr> userAttr;
}
