package com.hgb.spring.transaction.service.impl;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hgb.spring.transaction.dto.User;
import com.hgb.spring.transaction.dto.UserAttr;
import com.hgb.spring.transaction.mapper.UserMapper;
import com.hgb.spring.transaction.service.UserAttrService;
import com.hgb.spring.transaction.service.UserService;

/**
 * @author huang.guangbing
 * @since 2024/9/8
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserAttrService userAttrService;

    @Override
    public User findUserById(@NotNull Long id) {
        final User user = userMapper.selectById(id);
        final List<UserAttr> userAttrs = userAttrService.selectByUserId(user.getUserId());
        user.setUserAttr(userAttrs);
        return user;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addUser(@NotNull User user) throws Exception {
        userMapper.insert(user);

        final UserAttr userAttr = UserAttr.builder().userId(user.getUserId()).attrName("attrName").attrValue("attrValue").build();

        userAttrService.insert_propagation_requires_new(userAttr);
        //throw new Exception("hgbException");
    }

    @Override
    //@Transactional(rollbackFor = Exception.class)
    public void addUser_mandatory(@NotNull User user) throws Exception {
        userMapper.insert(user);

        final UserAttr userAttr = UserAttr.builder().userId(user.getUserId()).attrName("attrName").attrValue("attrValue").build();

        userAttrService.insert_propagation_mandatory(userAttr);
        //throw new Exception("hgbException");
    }

    @Override
    public User modifyUser(User user) {
        final User update = userMapper.update(user);
        return update;
    }

    @Override
    public int removeUser(@NotNull Long id) {
        return userMapper.deleteById(id);
    }
}
