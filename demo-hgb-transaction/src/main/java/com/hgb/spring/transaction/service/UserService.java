package com.hgb.spring.transaction.service;

import com.hgb.spring.transaction.dto.User;

/**
 * @author huang.guangbing
 * @since 2024/9/8
 */
public interface UserService {

    User findUserById(Long id);

    void addUser(User user) throws Exception;

    void addUser_mandatory(User user) throws Exception;

    User modifyUser(User user);

    int removeUser(Long id);
}
