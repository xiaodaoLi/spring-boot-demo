package com.hgb.spring.transaction.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hgb.spring.transaction.dto.User;

/**
 * @author huang.guangbing
 * @since 2024/9/8
 */
@Mapper
public interface UserMapper {
    void insert(User user);

    //@Select("SELECT * FROM user WHERE user_id = #{id}")
    User selectById(@Param("id") Long id);

    User update(User user);

    int deleteById(Long id);

}
