package com.hgb.spring.transaction.service;

import java.util.List;

import com.hgb.spring.transaction.dto.UserAttr;

/**
 * @author huang.guangbing
 * @since 2024/9/9
 */
public interface UserAttrService {
    int deleteByPrimaryKey(Long userAttrId);

    /**
     * requires_new 父事务失败不影响子事务
     * @param record
     * @return
     */
    int insert_propagation_requires_new(UserAttr record);

    /**
     * 要求必须存在于事务当中
     * @param record
     * @return
     */
    int insert_propagation_mandatory(UserAttr record);
    //int insert(UserAttr record);

    int insertSelective(UserAttr record);

    UserAttr selectByPrimaryKey(Long userAttrId);

    int updateByPrimaryKeySelective(UserAttr record);

    int updateByPrimaryKey(UserAttr record);

    List<UserAttr> selectByUserId(Long userId);
}

