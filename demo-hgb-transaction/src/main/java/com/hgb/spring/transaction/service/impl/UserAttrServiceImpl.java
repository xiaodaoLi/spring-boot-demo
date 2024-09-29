package com.hgb.spring.transaction.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hgb.spring.transaction.dto.UserAttr;
import com.hgb.spring.transaction.mapper.UserAttrMapper;
import com.hgb.spring.transaction.service.UserAttrService;

/**
 * @author huang.guangbing
 * @since 2024/9/9
 */
@Service
public class UserAttrServiceImpl implements UserAttrService {


    @Autowired
    private UserAttrMapper userAttrMapper;

    @Override
    public int deleteByPrimaryKey(Long userAttrId) {
        return userAttrMapper.deleteByPrimaryKey(userAttrId);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public int insert_propagation_requires_new(UserAttr record) {
        final int insertCount = userAttrMapper.insert(record);
        //System.out.println(1 / 0);
        return insertCount;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)
    public int insert_propagation_mandatory(UserAttr record) {
        final int insertCount = userAttrMapper.insert(record);
        //System.out.println(1 / 0);
        return insertCount;
    }

    @Override
    public int insertSelective(UserAttr record) {
        return userAttrMapper.insertSelective(record);
    }

    @Override
    public UserAttr selectByPrimaryKey(Long userAttrId) {
        return userAttrMapper.selectByPrimaryKey(userAttrId);
    }

    @Override
    public int updateByPrimaryKeySelective(UserAttr record) {
        return userAttrMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserAttr record) {
        return userAttrMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<UserAttr> selectByUserId(Long userId) {
        return userAttrMapper.selectByUserId(userId);
    }
}

