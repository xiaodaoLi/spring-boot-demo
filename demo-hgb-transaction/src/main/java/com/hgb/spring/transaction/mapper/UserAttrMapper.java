package com.hgb.spring.transaction.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hgb.spring.transaction.dto.UserAttr;

/**
 * @author huang.guangbing
 * @since 2024/9/9
 */
public interface UserAttrMapper {
    int deleteByPrimaryKey(Long userAttrId);

    int insert(UserAttr record);

    int insertSelective(UserAttr record);

    UserAttr selectByPrimaryKey(Long userAttrId);

    int updateByPrimaryKeySelective(UserAttr record);

    int updateByPrimaryKey(UserAttr record);

    List<UserAttr> selectByUserId(@Param("userId")Long userId);



}
