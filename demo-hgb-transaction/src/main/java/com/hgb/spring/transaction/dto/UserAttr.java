package com.hgb.spring.transaction.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huang.guangbing
 * @since 2024/9/9
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAttr {
    private Long userAttrId;

    private String attrName;

    private String attrValue;

    private Long userId;

    private String userName;

    private Integer userAge;

    private String userSex;

}
